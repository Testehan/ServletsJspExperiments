package com.testehan.openliberty.servlet.chpt17;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class PasswordUtil {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray = md.digest();

        // this method is taken from the book...there are various solutions/libraries to this type
        // of processing..see
        // https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();

    }

    public static String getSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }


    public static String hashAndSaltPassword(String password) throws NoSuchAlgorithmException {
        String salt = getSalt(); // this would need to be stored in the DB in a user's column
        System.out.println("Salt="+salt);
        return hashPassword(password + salt);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hashPassword("abc"));

        System.out.println(hashAndSaltPassword("abc"));

        System.out.println(hashAndSaltPassword("abc"));
    }
}