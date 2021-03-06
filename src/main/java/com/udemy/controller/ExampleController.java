package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import com.udemy.controller.components.ExampleComponents;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponents excomponent;

	public static String EXAMPLE_VIEW = "example";

	@GetMapping("/exampleString")
	public String ExampleString(Model model) {
		excomponent.sayHello();
		model.addAttribute("persons", exampleService.getLisPersons());
		model.addAttribute("person", new Person("Jon", 23));
		return EXAMPLE_VIEW;
	}

	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);

		mav.addObject("persons", exampleService.getLisPersons());
		mav.addObject("person", new Person("Mikel", 30));

		return mav;
	}

}
