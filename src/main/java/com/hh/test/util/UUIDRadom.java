package com.hh.test.util;

import java.util.UUID;

public class UUIDRadom {

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

	
	public static void main(String[] args) {
		System.out.println(new UUIDRadom().getUUID());
	}
}
