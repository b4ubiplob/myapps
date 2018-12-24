package sampledbwebapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingTool {

	public static String getHashCode(Object... instances) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Object object : instances) {
			stringBuilder.append(object.toString());
		}
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(stringBuilder.toString().getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
