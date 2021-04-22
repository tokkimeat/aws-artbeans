package com.spboot.test.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spboot.test.service.MailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MailController {

	@Autowired
	private MailService mailService;

	@PostMapping("/mail")
	public Integer sendMail(@RequestBody SimpleMailMessage smm) {
		log.info("smm=>{}", smm);
		mailService.mailSend(smm);
		return 1;
	}

	public static void main(String[] args) {
		Random r = new Random();
	String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for(int i =1 ;i<=6;i++) {
		int rNum = r.nextInt(str.length());
		char c = str.charAt(rNum);
		System.out.println(c);
	}
	}
}
