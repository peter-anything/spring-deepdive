package com.gsir.springdemo.test.v1;

import com.gsir.springdemo.beans.factory.BeanDefinition;
import com.gsir.springdemo.beans.factory.config.BeanDefinitionRegistry;
import com.gsir.springdemo.beans.factory.support.DefaultBeanFactory;
import com.gsir.springdemo.beans.factory.xml.XmlBeanDefinitionReader;
import com.gsir.springdemo.resource.ClassPathResource;
import com.gsir.springdemo.test.service.v1.PetStoreService;

import org.junit.Assert;
import org.junit.Test;

public class BeanDefinitionTest {
    @Test
    public void testBeanDefinition() throws Exception {
        BeanDefinitionRegistry bdr = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlDefinitionReader = new XmlBeanDefinitionReader(bdr);
        xmlDefinitionReader.reader(new ClassPathResource("pet-store.xml"));
        BeanDefinition bd = bdr.getBeanDefinition("petStore");
        Assert.assertNotNull(bd);
        Assert.assertEquals(bd.getBeanClassName(), "com.gsir.monitor.service.v1.PetStoreService");
    }

    @Test
    public void testGetBean() throws Exception {
        DefaultBeanFactory bdr = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(bdr);
        xmlBeanDefinitionReader.reader(new ClassPathResource("pet-store.xml"));
        PetStoreService pss = (PetStoreService) bdr.getBean("petStore");
        Assert.assertNotNull(pss);
    }
}
