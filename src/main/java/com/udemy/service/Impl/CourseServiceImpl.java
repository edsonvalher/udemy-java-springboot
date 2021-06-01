package com.udemy.service.Impl;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJPARepository;
import com.udemy.service.CourseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;

    @Override
    public List<Course> listAllCourses() {
        LOG.info("Call: listAllCourses()");
        return courseJPARepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        LOG.info("Call: addCourse() " + " -- PARAM: " + course.toString());
        return courseJPARepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
        courseJPARepository.deleteById(id);
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseJPARepository.save(course);
    }

}