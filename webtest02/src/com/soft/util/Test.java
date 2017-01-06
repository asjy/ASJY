package com.soft.util;

public class Test {

	public static void main(String[] args) {
		
		String str = "a2345";
		
		String reg = "[0-9a-zA-Z]";
		
		reg = "[0-9a-zA-Z]{6,16}";
		
		reg = "[a-zA-Z][0-9a-zA-Z]{5,15}";
		
		boolean value = str.matches(reg);
		System.out.println(value);
		
	}

}
