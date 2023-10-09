package de.tramotech.utils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * Author: Ahmed Fikri
 */
public class KeyGeneration {
    public static void gen() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 256 bits
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] aesKeyBytes = secretKey.getEncoded();
        System.out.println("AES Key: " + bytesToHex(aesKeyBytes));
    }

    // Helper method to convert bytes to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}

