package com.udemy.controller;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final String COURSES_VIEW = "courses";

    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @GetMapping("/listcourses")
    public ModelAndView listAllCourses() {
        LOG.info("CALL: " + "listAllCourses()");
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        mav.addObject("course", new Course());
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }

    @PostMapping("/addcourse")
    public RedirectView addCourse(@ModelAttribute("course") CourseModel courseModel) {

        Course course = new Course();
        course = courseConverter.modelToentity(courseModel);

        LOG.info("CALL: " + "addCourse()" + " - PARAM: " + course.toString());
        courseService.addCourse(course);
        return new RedirectView("/courses/listcourses");
    }

}