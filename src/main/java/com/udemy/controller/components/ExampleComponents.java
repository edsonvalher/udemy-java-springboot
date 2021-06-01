package com.udemy.controller.components;

import com.udemy.repository.CourseJPARepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponents {

    private static final Log LOG = LogFactory.getLog(ExampleComponents.class);

    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;

    public void sayHello() {

        LOG.info("HELLO from component!");

    }

}