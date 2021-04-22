package com.spboot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spboot.test.entity.UserInfo;
import com.spboot.test.repository.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserInfoController {
	
	@Autowired
	private UserInfoRepository uiRepo;

	
	@PostMapping("/user")
	public @ResponseBody Integer insert(@RequestBody UserInfo user	) {
	log.info("user=>{}",user);
	uiRepo.save(user);
		return user.getUserNum();
	}
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		UserInfo ui = new UserInfo();
		ui.setUserID("test");
		ui.setUserPwd("test");
		ui.setUserName("test");
		ui.setUserGender("남자");
		ui.setUserDateOfBirth("2010-10-11");
		ui.setUserAddr1("전라남도 광주광역시");
		ui.setUserAddr2("이써이써");
		ui.setUserPhone1("010");
		ui.setUserPhone2("6208");
		ui.setUserPhone3("0101");
	String json = om.writeValueAsString(ui);
	log.info(json);
	}
}
