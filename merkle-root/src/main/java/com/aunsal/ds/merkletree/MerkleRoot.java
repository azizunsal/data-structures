package com.aunsal.ds.merkletree;

import com.aunsal.ds.merkletree.utils.HashUtils;

import java.util.ArrayList;

public class MerkleRoot {

    public String findMerkleRoot(ArrayList<String> txList) {
        if (txList == null) return null;
        return createMerkleRoot(txList).get(0);
    }

    private ArrayList<String> createMerkleRoot(ArrayList<String> txList) {
        if (txList.size() == 1) return txList;

        ArrayList<String> newList = new ArrayList<>();

        for (int i = 0; i < txList.size(); i += 2) {
            String tx1 = txList.get(i);
            String tx2;
            if (i + 1 < txList.size()) {
                tx2 = txList.get(i + 1);
            } else {
                tx2 = txList.get(i);
            }
            // Double hashing was Satoshi's idea. "SHA-256d"
            newList.add(HashUtils.doubleHash(tx1, tx2));
        }
        return createMerkleRoot(newList);
    }
}
