package com.aunsal.ds.merkletree.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public final class HashUtils {
    public static String doubleHash(String tx1, String tx2) {
        HexFormat hexFormat = HexFormat.of();
        // Get bytes
        byte[] tx1Bytes = hexFormat.parseHex(tx1);
        byte[] tx2Bytes = hexFormat.parseHex(tx2);

        // Due to Bitcoin's little endian big endian difference,
        //  we need to reverse arrays before and after hashing
        reverseByteArray(tx1Bytes);
        reverseByteArray(tx2Bytes);

        byte[] combinedBytes = mergeByteArrays(tx1Bytes, tx2Bytes);

        // Double hash combined bytes
        byte[] hash = new byte[0];
        try {
            hash = sha256(sha256(combinedBytes));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error while hashing!" + e);
        }
        reverseByteArray(hash);
        return hexFormat.formatHex(hash);
    }

    public static byte[] mergeByteArrays(byte[] arr1, byte[] arr2) {
        byte[] combinedArray = new byte[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, combinedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, combinedArray, arr1.length, arr2.length);
        return combinedArray;
    }

    public static void reverseByteArray(byte[] bytes) {
        int s = 0, e = bytes.length - 1;
        while (s < e) {
            byte temp = bytes[e];
            bytes[e] = bytes[s];
            bytes[s] = temp;
            s++;
            e--;
        }
    }

    public static byte[] sha256(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(bytes);
    }
}
