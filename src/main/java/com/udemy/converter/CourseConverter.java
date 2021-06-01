package com.udemy.converter;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {

    // 1 entity -> model
    public CourseModel entityTomodel(Course course) {
        CourseModel courseModel = new CourseModel();
        courseModel.setDescription(course.getDescription());
        courseModel.setName(course.getName());
        courseModel.setPrice(course.getPrice());
        courseModel.setHours(course.getHours());

        return courseModel;
    }

    // 2 model -> entity
    public Course modelToentity(CourseModel courseModel) {
        Course course = new Course();
        course.setDescription(courseModel.getDescription());
        course.setName(courseModel.getName());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());
        return course;
    }

}