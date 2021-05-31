package com.udemy.controller.components;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponents {

    private static final Log LOG = LogFactory.getLog(ExampleComponents.class);

    public void sayHello() {

        LOG.info("HELLO from component!");

    }

}