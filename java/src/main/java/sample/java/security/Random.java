package sample.java.security;

import java.security.SecureRandom;

public class Random
{
    public static byte[] getRandom(int size)
    {
        SecureRandom sr = new SecureRandom();
        byte[] random = new byte[32];
        sr.nextBytes(random);
        return random;
    }
}
