package com.demo.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptUtil {
	
	public static void main(String[] args) {
		System.out.println(encrypt("sa"));
		System.out.println(decrypt("ZpG9gB27kxQd7jxMdKx3kw=="));
	}

	static BasicTextEncryptor textEncryptor = new BasicTextEncryptor();   
	
	static {
		textEncryptor.setPassword("demo");
	}
	
	public static String encrypt(String str) {
		return textEncryptor.encrypt(str);
	}
	
	public static String decrypt(String str){ 
		return textEncryptor.decrypt(str);
	}
	
}
