package com.gsir.springdemo.resource;

import java.io.InputStream;

import org.springframework.util.ClassUtils;

public class ClassPathResource implements Resource {
    private String filePath;

    public ClassPathResource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public InputStream getInputStream() {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        return classLoader.getResourceAsStream(this.filePath);
    }

}
