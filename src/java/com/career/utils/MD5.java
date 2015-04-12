package com.career.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public String getMD5Password(String password) {
		String md5pass = null;

		MessageDigest msg = null;
		try {
			msg = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg.update(password.getBytes());
		byte byteData[] = msg.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		md5pass = sb.toString();

		return md5pass;
	}
}
