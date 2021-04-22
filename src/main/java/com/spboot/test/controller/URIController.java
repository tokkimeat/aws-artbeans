package com.spboot.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class URIController {

	@GetMapping("/views/**")
	public void goPage() {
		log.info("goPage실행중");
	}
	@GetMapping("/")
	public String goIndex() {
		return "views/index";
	}
}
