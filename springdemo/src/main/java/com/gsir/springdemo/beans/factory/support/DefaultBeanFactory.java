package com.gsir.springdemo.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import com.gsir.springdemo.beans.factory.BeanDefinition;
import com.gsir.springdemo.beans.factory.config.BeanDefinitionRegistry;
import com.gsir.springdemo.beans.factory.config.ConfigurableBeanFactory;
import com.gsir.springdemo.util.ClassUtils;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry 
    implements ConfigurableBeanFactory, BeanDefinitionRegistry  {

    private ClassLoader classLoader;
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String beanId) {
        // TODO Auto-generated method stub
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if (bd.isSingleton()) {
            Object obj = this.getSingleton(beanId);
            if (obj == null) {
                obj = createBean(bd);
                this.registerSingleton(beanId, obj);
            }

            return obj;
        }

        return createBean(bd);
    }

    private Object createBean(BeanDefinition bd) {
         String beanClassName = bd.getBeanClassName();
         ClassLoader classLoader = this.getBeanClassLoader();
         Class<?> clz = null;
         try {
             clz = classLoader.loadClass(beanClassName);
 
             return clz.newInstance();
         } catch(Exception e) {
             throw new RuntimeException(e);
         }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitionMap.get(beanId);
    }

    @Override
    public void setBeanDefinition(String beanId, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanId, bd);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }
}
