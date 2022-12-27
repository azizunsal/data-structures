package com.aunsal.ds.merkletree.client;

import com.aunsal.ds.merkletree.MerkleRoot;
import com.aunsal.ds.merkletree.utils.FileUtils;

import java.util.ArrayList;

public class Client {
    private static final String BITCOIN_BLOCK_170_FILENAME = "BitcoinBlock170TXs.txt";
    private static final String BITCOIN_BLOCK_286819_FILENAME = "BitcoinBlock286819TXs.txt";

    public static void main(String[] args) {
        MerkleRoot merkleRoot = new MerkleRoot();
        ArrayList<String> bitcoinBlock170TxList = FileUtils.getResourceFileAsString(BITCOIN_BLOCK_286819_FILENAME);
        String root = merkleRoot.findMerkleRoot(bitcoinBlock170TxList);
        System.out.println("merkle root=" + root);
    }
}
