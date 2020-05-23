package com.gsir.springdemo.context;

import com.gsir.springdemo.beans.factory.support.DefaultBeanFactory;
import com.gsir.springdemo.beans.factory.xml.XmlBeanDefinitionReader;
import com.gsir.springdemo.resource.Resource;

public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory defaultBeanFactory = null;

    public AbstractApplicationContext(String filePath) throws Exception {
        defaultBeanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultBeanFactory);
        Resource resource = getResourceByPath(filePath);
        reader.reader(resource);
    }

    public abstract Resource getResourceByPath(String filePath);

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        defaultBeanFactory.setBeanClassLoader(classLoader);
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return defaultBeanFactory.getBeanClassLoader();
    }

    @Override
    public Object getBean(String beanId) {
        return defaultBeanFactory.getBean(beanId);
    }
}
