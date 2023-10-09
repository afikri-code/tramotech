package de.tramotech.utils;

import java.security.NoSuchAlgorithmException;
/**
 * Author: Ahmed Fikri
 */
public class EntryPoint {

    public static void main(String[] args) {
        if(args.length == 0) {
            try {
                KeyGeneration.gen();

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
        if (args.length < 3) {
            System.out.println("Usage: EncryptionApp <encrypt/decrypt> <value> <key>");
            System.exit(1);
        }

        String option = args[0].toLowerCase();
        String value = args[1];
        String key = args[2];

        try {
            CustomEncryptionUtil encryptionUtil = new CustomEncryptionUtil(key);

            if ("encrypt".equals(option)) {
                String encryptedValue = encryptionUtil.encrypt(value);
                System.out.println("Encrypted: " + encryptedValue);
            } else if ("decrypt".equals(option)) {
                String decryptedValue = encryptionUtil.decrypt(value);
                System.out.println("Decrypted: " + decryptedValue);
            } else {
                System.out.println("Invalid option: Use 'encrypt' or 'decrypt'");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}

