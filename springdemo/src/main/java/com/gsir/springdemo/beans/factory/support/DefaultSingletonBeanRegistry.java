package com.gsir.springdemo.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import com.gsir.springdemo.beans.factory.config.SingletonBeanRegistry;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<String, Object>();

    @Override
    public void registerSingleton(String beanId, Object obj) {
        if (this.getSingleton(beanId) != null) {
            throw new RuntimeException("beanId : " + beanId + "exists");
        }

        this.singletonObjects.put(beanId, obj);
    }

    @Override
    public Object getSingleton(String beanId) {
        return this.singletonObjects.get(beanId);
    }
    
}
