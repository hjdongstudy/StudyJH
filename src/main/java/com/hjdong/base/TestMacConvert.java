package com.hjdong.base;

public class TestMacConvert {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] macbyte = new byte[] { (byte) 56, (byte) 52, (byte) 67, (byte) 50, (byte) 69, (byte) 52, (byte) 70,
				(byte) 54, (byte) 52, (byte) 65, (byte) 68, (byte) 68};
		System.out.println(new String(macbyte));
		
	}

	static byte[] macstr2macbyte(String macstr) {
		byte[] mac = new byte[6];
		int i = 0;
		for (String str : macstr.split("\\:")) {
			mac[i++] = (byte) Integer.parseInt(str, 16);
		}
		return mac;
	}

	static String macbyte2macstr(byte[] mac) {
		String macStr = "";
		for (int i = 0; i < mac.length; i++) {
			macStr += Integer.toHexString(mac[i] & 0xFF);
			if (i < (mac.length - 1)) {
				macStr += "-";
			}
		}
		return macStr;
	}
}
