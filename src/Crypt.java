import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Crypt {
	static byte[] raw;
	byte[] skey=new byte[1000];

	

	public Crypt(int number) {
		// TODO Auto-generated method stub
		try{
			generateSymmetrickey();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private void generateSymmetrickey() {
		// TODO Auto-generated method stub
		try{
		Random r=new Random();
		int num = r.nextInt(10000);
		String knum=String.valueOf(num);
		byte[] kNumb=knum.getBytes();
		skey=getRawKey(kNumb);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static  byte[] getRawKey(byte[] kNumb)throws Exception {
		// TODO Auto-generated method stub
		KeyGenerator kgen=KeyGenerator.getInstance("AES");
		SecureRandom sr=SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(kNumb);
		kgen.init(128,sr);
		SecretKey skey=kgen.generateKey();
		raw=skey.getEncoded();
		return raw;
	}

	public static byte[] encrypt(byte[] raw2, byte[] ibyte)throws Exception {
		// TODO Auto-generated method stub
		SecretKeySpec skeySpec=new SecretKeySpec(raw2, "AES");
		Cipher cipher=Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted=cipher.doFinal(ibyte);
		return encrypted;
	}
	
	public static byte[] decrypt(byte[] raw,byte[] encrypted)throws Exception{
		SecretKeySpec skeySpec=new SecretKeySpec(raw, "AES");
		Cipher cipher=Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE,skeySpec);
		byte[] decrypted=cipher.doFinal(encrypted);
		return decrypted;
		
	}

}
