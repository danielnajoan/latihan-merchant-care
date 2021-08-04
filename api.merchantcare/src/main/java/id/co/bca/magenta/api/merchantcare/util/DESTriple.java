
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
package id.co.bca.magenta.api.merchantcare.util;

import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

public class DESTriple {
	private SecretKey desKey;
	private final static String HEX_DIGITS = "0123456789ABCDEF";

	public DESTriple(byte[] key) {
		createCipher(key);
	}

	public void createCipher(byte[] desKeyData) {
		try {
			if (!(desKeyData.length == 16 || desKeyData.length == 24)) {
				return;
			}
			byte[] key = new byte[24];
			if (desKeyData.length == 16) {
				for (int za = 0; za < 16; za++) {
					key[za] = desKeyData[za];
				}
				for (int za = 0; za < 8; za++) {
					key[za + 16] = desKeyData[za];
				}
			}
			if (desKeyData.length == 24) {
				for (int za = 0; za < 24; za++) {
					key[za] = desKeyData[za];
				}
			}

			DESedeKeySpec desKeySpec = new DESedeKeySpec(key);
			SecretKeyFactory keyFactory = null;
			keyFactory = SecretKeyFactory.getInstance("DESede");
			desKey = keyFactory.generateSecret(desKeySpec);
		} catch (NoSuchAlgorithmException ex1) {
		} catch (InvalidKeyException ex2) {
		} catch (InvalidKeySpecException ex3) {
		}
	}

	public byte[] encryptECB(byte[] cleartext) {
		byte[] ciphertext = null;
		try {
			Cipher desCipher;
			desCipher = Cipher.getInstance("DESede/ECB/NoPadding");
			desCipher.init(Cipher.ENCRYPT_MODE, desKey);
			ciphertext = desCipher.doFinal(cleartext);
		} catch (NoSuchAlgorithmException ex1) {
		} catch (InvalidKeyException ex2) {
		} catch (NoSuchPaddingException ex3) {
		} catch (BadPaddingException ex4) {
		} catch (IllegalBlockSizeException ex5) {
		} catch (IllegalStateException ex6) {
		}
		return ciphertext;
	}

	public byte[] decryptECB(byte[] ciphertext) {
		byte[] cleartext = null;
		try {
			Cipher desCipher;
			desCipher = Cipher.getInstance("DESede/ECB/NoPadding");
			desCipher.init(Cipher.DECRYPT_MODE, desKey);
			cleartext = desCipher.doFinal(ciphertext);
		} catch (NoSuchAlgorithmException ex1) {
		} catch (InvalidKeyException ex2) {
		} catch (NoSuchPaddingException ex3) {
		} catch (BadPaddingException ex4) {
		} catch (IllegalBlockSizeException ex5) {
		} catch (IllegalStateException ex6) {
		}
		return cleartext;
	}

	public byte[] encryptCBC(byte[] cleartext) {
		byte[] ciphertext = null;
		byte[] iv = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
		AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);

		try {
			Cipher desCipher;
			desCipher = Cipher.getInstance("DESede/CBC/NoPadding");
			desCipher.init(Cipher.ENCRYPT_MODE, desKey, paramSpec);
			ciphertext = desCipher.doFinal(cleartext);
			iv = desCipher.getIV();

		} catch (NoSuchAlgorithmException ex1) {
		} catch (InvalidKeyException ex2) {
		} catch (NoSuchPaddingException ex3) {
		} catch (BadPaddingException ex4) {
		} catch (IllegalBlockSizeException ex5) {
		} catch (IllegalStateException ex6) {
		} catch (InvalidAlgorithmParameterException ex7) {
		}
		return ciphertext;
	}

	public byte[] decryptCBC(byte[] ciphertext) {
		byte[] cleartext = null;
		byte[] iv = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, '\0' };
		IvParameterSpec paramSpec = new IvParameterSpec(iv);

		try {
			Cipher desCipher;
			desCipher = Cipher.getInstance("DESede/CBC/NoPadding");
			desCipher.init(Cipher.DECRYPT_MODE, desKey, paramSpec);
			cleartext = desCipher.doFinal(ciphertext);
			iv = paramSpec.getIV();
		} catch (NoSuchAlgorithmException ex1) {
		} catch (InvalidKeyException ex2) {
		} catch (NoSuchPaddingException ex3) {
		} catch (BadPaddingException ex4) {
		} catch (IllegalBlockSizeException ex5) {
		} catch (IllegalStateException ex6) {
		} catch (InvalidAlgorithmParameterException ex7) {
			ex7.printStackTrace();
		}
		return cleartext;
	}

	public byte[] fromHexString(String s) {
		/* 
		 * Check length of string if even or odd number
		 * if odd then add 1 to length 
		 * if index already at last substring from index*i to length of string 
		 * to avoid fault on substring
		 */
		int lastIndex = s.length() % 2 == 0 ? s.length() / 2 : (s.length() + 1) /2;
		byte bytes[] = new byte[lastIndex];
		for (int i = 0; i < lastIndex; i++) {
			if(i == lastIndex-1){
				bytes[i] = (byte) (Integer.parseInt(s.substring(2 * i, s.length()), 16));
			}else {
				bytes[i] = (byte) (Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16));
			}
		}
		return bytes;
//		byte bytes[] = new byte[s.length() / 2];
//		for (int i = 0; i < s.length() / 2; i++) {
//			bytes[i] = (byte) (Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16));
//		}
//		return bytes;
	}

	public String toHexString(byte b[]) {
		if ((b == null) || (b.length == 0)) {
			return "";
		} else {
			return toHexString(b, 0, b.length);
		}
	}

	/** Convert bytes to HEX string */
	private String toHexString(byte b[], int off, int len) {
		StringBuffer s = new StringBuffer();
		for (int i = off; i < off + len; i++) {
			s.append(HEX_DIGITS.charAt((b[i] & 0xff) >> 4));
			s.append(HEX_DIGITS.charAt(b[i] & 0xf));
		}
		return s.toString();
	}

	public String cleanData(String orig) {
		StringBuffer buff = new StringBuffer();
		char[] chars = orig.toCharArray();
		for (int za = 0; za < chars.length; za++) {
			char tmp = chars[za];
			if (!(tmp == 0x00)) {
				buff.append(tmp);
			}
		}
		return buff.toString();
	}

	public String paddData(String orig) {
		StringBuffer buff = new StringBuffer();
		buff.append(orig);
		int paddSize = 0;
		if (orig.length() % 8 != 0)
			paddSize = 8 - (orig.length() % 8);
		for (int za = 0; za < paddSize; za++) {
			buff.append((char) 0x00);
		}
		return buff.toString();
	}

	public String encrypt(String data) {
		String retval = "";
		byte[] encrypted = encryptECB(paddData(data).getBytes());
		retval = toHexString(encrypted);
		return retval;
	}

	public String decrypt(String data) {
		String retval = "";
		byte[] decrypted = decryptECB(fromHexString(data));
		retval = cleanData(new String(decrypted));
		return retval;
	}

	public static void main(String args[]) {
		// key untuk test ( PRJ1 )
		// String key="123456789012345678901234";
		String key = "tonimurniantogiantofsdpr";
		String data = "password";

		DESTriple DES = new DESTriple(key.getBytes());

		// untuk encrypt password
		System.out.println("Encrypted password : " + DES.encrypt(data));

		// untuk decrypt password
		String encryptPass = DES.encrypt(data);
		System.out.println("Clean password : " + DES.decrypt(encryptPass));
	}
}
