package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

import org.springframework.stereotype.Repository;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager eManager;

    public Course find(boolean exist) {

        JPAQuery<Course> query = new JPAQuery<Course>(eManager);

        Predicate initial = qCourse.description.endsWith("ET");

        BooleanBuilder predicateBooleanBuilder = new BooleanBuilder(initial);

        if (exist) {
            Predicate predicate2 = qCourse.id.eq(5);
            predicateBooleanBuilder.and(predicate2);
        } else {
            Predicate predicate3 = qCourse.name.endsWith("ET");
            predicateBooleanBuilder.or(predicate3);

        }
        return query.select(qCourse).from(qCourse).where(predicateBooleanBuilder).fetchOne();

        // List<Course> courses =
        // query.select(qCourse).from(qCourse).where(qCourse.hours.between(20,
        // 50)).fetch();
    }

}