package com.udemy.repository;

import java.io.Serializable;
import java.util.List;

import com.udemy.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseJPARepository")
public interface CourseJPARepository extends JpaRepository<Course, Serializable> {

}