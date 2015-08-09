package ua.lviv.lgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/main")
	public String goToWelcome() {
		System.out.println("in contoller");
		return "main";
	}
}
