package com.gsir.springdemo.beans.factory.config;

public interface SingletonBeanRegistry {
    void registerSingleton(String beanId, Object obj);

    Object getSingleton(String beanId);
}
