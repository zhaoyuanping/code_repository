package com.chlab.zylht.controller;

import org.springframework.web.context.ContextLoader;

public class CommonUtil {
	
	public static Object getBean(String name) {
		
		return ContextLoader.getCurrentWebApplicationContext().getBean(name);
	}
	
	public static boolean isEmptyString(Object s) {
		
		return null == s || "".equals(s.toString());
	}
}
