package com.aunsal.ds.merkletree.utils;

import com.aunsal.ds.merkletree.MerkleRoot;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public final class FileUtils {
    public static ArrayList<String> getResourceFileAsString(String fileName) {
        InputStream is = getResourceFileAsInputStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return (ArrayList<String>) reader.lines().collect(Collectors.toList());
        } else {
            throw new RuntimeException("Resource not found!");
        }
    }

    public static InputStream getResourceFileAsInputStream(String fileName) {
        ClassLoader classLoader = MerkleRoot.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
