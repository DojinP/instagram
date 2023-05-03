package com.multi.instagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class HomeController {
//	@RequestMapping(value = "/index.html")
	public String home() {
//		return "main/instagram_main_page";
		return "main/index";
	}
}
