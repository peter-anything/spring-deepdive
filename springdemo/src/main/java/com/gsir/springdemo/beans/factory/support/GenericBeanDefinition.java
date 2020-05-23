package com.gsir.springdemo.beans.factory.support;

import com.gsir.springdemo.beans.factory.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {
    private String beanId;
    private String beanClassName;
    private String scope = SCOPE_DEFAULT;
    private boolean singleton = true;
    private boolean prototype = false;

    public GenericBeanDefinition(String beanId, String beanClassName) {
        this.beanId = beanId;
        this.beanClassName = beanClassName;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }
    @Override
    public boolean isPrototype() {
        return this.prototype;
    }
    @Override
    public String getScope() {
        return this.scope;
    }
    @Override
    public void setScope(String scope) {
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = !this.singleton;
        this.scope = scope;
    }
    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }
    @Override
    public String getBeanId() {
        return this.beanId;
    }
}
