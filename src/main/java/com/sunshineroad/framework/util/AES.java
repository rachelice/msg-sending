package com.sunshineroad.framework.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * omplatform
 * com.sunshineroad.framework.util
 * @{#} AES.java Create on  2013-6-13 上午9:02:12
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：对字串进行AES加密和解密
 *
 */

public class AES {
	private static final int ENCODE = 0;
	private static final int DECODE = 1;

	/**
	 * 生成AES密钥
	 */
	public static void generatekey() throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		SecureRandom random = new SecureRandom();
		keygen.init(random);
		SecretKey key = keygen.generateKey();
		FileOutputStream keyfile = new FileOutputStream(getkeypath());
		ObjectOutputStream keyout = new ObjectOutputStream(keyfile);
		keyout.writeObject(key);
		keyout.close();
	}

	/**
	 * 加密方法
	 */
	public static String encode(String key) throws Exception {
		return AEScrypt(ENCODE, key);
	}

	/**
	 * 解密方法
	 */
	public static String decode(String key) throws Exception {
		return AEScrypt(DECODE, key);
	}

	/**
	 * AES 加密解密
	 */
	private static String AEScrypt(int code, String keytext) throws Exception {
		int mode = 0;
		byte[] keybytes = null;

		if (0 == code) {
			mode = Cipher.ENCRYPT_MODE;
			keybytes = keytext.getBytes();
		} else if (1 == code) {
			mode = Cipher.DECRYPT_MODE;
			keybytes = hex2byte(keytext);
		}

		FileInputStream keyfile = new FileInputStream(getkeypath());
		ObjectInputStream keyIn = new ObjectInputStream(keyfile);
		Key key = (Key) keyIn.readObject();
		keyIn.close();

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(mode, key);

		byte[] outBytes = cipher.doFinal(keybytes);
		if (0 == code) {
			return byte2hex(outBytes).toLowerCase();
		} else if (1 == code) {
			return new String(outBytes);
		}
		return null;
	}

	/**
	 * 十六进制字串转为字节数组
	 */
	private static byte[] hex2byte(String hex) {
		if (hex == null)
			return null;
		int l = hex.length();
		if (l % 2 == 1)
			return null;
		byte[] bytes = new byte[l / 2];
		for (int i = 0; i != l / 2; i++)
			bytes[i] = (byte) Integer.parseInt(hex.substring(i * 2, i * 2 + 2),
					16);
		return bytes;
	}

	/**
	 * 获取密钥保存路径
	 */
	private static String getkeypath() throws IllegalAccessException{
		String path=AES.class.getProtectionDomain().getCodeSource()
		     .getLocation().getPath();
		if (path.indexOf("framework") > 0) {
		    path = path.substring(0, path.indexOf("framework"))+"/resource/key/key.dat";
		   } else {
		    throw new IllegalAccessException("路径获取错误");
		   }
		return path;
	}

	/**
	 * 字节数组转为十六进制字串
	 */
	private static String byte2hex(byte[] bytes) {
		String hs = "";
		String stmp = "";
		for (int i = 0; i < bytes.length; i++) {
			stmp = (java.lang.Integer.toHexString(bytes[i] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

}
