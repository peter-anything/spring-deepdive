package com.gsir.springdemo.context.support;

import com.gsir.springdemo.context.AbstractApplicationContext;
import com.gsir.springdemo.resource.ClassPathResource;
import com.gsir.springdemo.resource.Resource;

public class ClassPathApplicationContext extends AbstractApplicationContext {

    public ClassPathApplicationContext(String filePath) throws Exception {
        super(filePath);
    }

    @Override
    public Resource getResourceByPath(String filePath) {
        return new ClassPathResource(filePath);
    }
}
