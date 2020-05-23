package com.gsir.springdemo.test.v1;

import com.gsir.springdemo.resource.ClassPathResource;
import com.gsir.springdemo.resource.Resource;
import org.springframework.util.Assert;

public class ResourceTest {

    public void test1() {
        Resource resource = new ClassPathResource("pet-store.xml");
        Assert.notNull(resource.getInputStream(), "");
    }
}
