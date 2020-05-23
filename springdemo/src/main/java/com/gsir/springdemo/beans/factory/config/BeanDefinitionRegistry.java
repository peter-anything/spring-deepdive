package com.gsir.springdemo.beans.factory.config;

import com.gsir.springdemo.beans.factory.BeanDefinition;

public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanId);

    void setBeanDefinition(String beanId, BeanDefinition bd);
}
