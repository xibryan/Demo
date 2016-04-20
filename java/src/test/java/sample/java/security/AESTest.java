package sample.java.security;

import org.junit.Test;

public class AESTest
{
    @Test
    public void test() throws Exception
    {
        String value = "test";
        String passwd = "Test12345_";

        byte[] encode = AES.encrypt(value, passwd);
        System.out.println(encode);

        String decode = AES.decrypt(encode, passwd);
        System.out.println(decode);
    }
}
