package com.gsir.springdemo.beans.factory.xml;

import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gsir.springdemo.beans.factory.BeanDefinition;
import com.gsir.springdemo.beans.factory.config.BeanDefinitionRegistry;
import com.gsir.springdemo.beans.factory.support.GenericBeanDefinition;
import com.gsir.springdemo.resource.Resource;

public class XmlBeanDefinitionReader {
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void reader(Resource resource) throws DocumentException {
        InputStream inputStream = resource.getInputStream();
        SAXReader reader = new SAXReader();
        Document doc = reader.read(inputStream);
        Element root = doc.getRootElement();
        @SuppressWarnings("unchecked")
        Iterator<Element> iter = root.elementIterator();
        while (iter.hasNext()) {
            Element ele = iter.next();
            String id = ele.attributeValue("id");
            String className = ele.attributeValue("class");
            BeanDefinition bd = new GenericBeanDefinition(id, className);
            this.beanDefinitionRegistry.setBeanDefinition(id, bd);
        }
    }
}
