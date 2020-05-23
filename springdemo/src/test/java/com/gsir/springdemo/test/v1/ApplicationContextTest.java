package com.gsir.springdemo.test.v1;

import com.gsir.springdemo.context.ApplicationContext;
import com.gsir.springdemo.context.support.ClassPathApplicationContext;
import com.gsir.springdemo.test.service.v1.PetStoreService;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationContextTest {

    @Test
    public void testGetBean() throws Exception {
        ApplicationContext appContext = new ClassPathApplicationContext("pet-store.xml");
        PetStoreService ptService = (PetStoreService) appContext.getBean("petStore");
        Assert.assertNotNull(ptService);
    }
}
