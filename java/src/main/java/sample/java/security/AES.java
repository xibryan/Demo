package sample.java.security;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES
{
    public static final String AES_CBC_MODE = "AES/CBC/PKCS5Padding";

    public static byte[] encrypt(String content, String password) throws Exception
    {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化

        byte[] byteContent = content.getBytes("utf-8");
        byte[] result = cipher.doFinal(byteContent);

        return result; // 加密
    }

    public static String decrypt(byte[] content, String password) throws Exception
    {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化

        byte[] result = cipher.doFinal(content);
        return new String(result);
    }

    public static byte[] cbcEncrypt(String content, String password) throws Exception
    {
        SecureRandom rnd = new SecureRandom();
        IvParameterSpec iv = new IvParameterSpec(rnd.generateSeed(16));

        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(256);
        SecretKey k = generator.generateKey();

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, k, iv);

        byte[] result = c.doFinal(content.getBytes());
        return result;
    }
}
