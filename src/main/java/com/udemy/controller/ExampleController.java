package com.udemy.controller;

import com.udemy.model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static String EXAMPLE_VIEW = "example";

	@GetMapping("/exampleString")
	public String ExampleString(Model model) {
		model.addAttribute("person", new Person("Jon", 23));
		return EXAMPLE_VIEW;
	}

	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Mikel", 30));
		return mav;
	}

}
