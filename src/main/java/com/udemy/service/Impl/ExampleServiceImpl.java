package com.udemy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.udemy.controller.components.RequestTimeInterceptor;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    @Override
    public List<Person> getLisPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Jon", 23));
        persons.add(new Person("Mikel", 30));
        persons.add(new Person("Eva", 43));
        persons.add(new Person("Peter", 23));
        LOG.info("HELLO FROM SERVICE");

        return persons;
    }

}