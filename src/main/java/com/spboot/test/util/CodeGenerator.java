package com.spboot.test.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class CodeGenerator {
	private static final String BASIC_CODE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int COOD_LENGTH = 6;

	public String getRandomCode() {
		StringBuilder sb = new StringBuilder();

		Random r;
		try {
			r = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			r = new Random();
		}
		for (int i = 0; i < COOD_LENGTH; i++) {
			int rNum = r.nextInt(BASIC_CODE.length());
			sb.append(BASIC_CODE.charAt(rNum));
		}
		return sb.toString();
	}
}
