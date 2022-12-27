package com.aunsal.ds.merkletree;

import com.aunsal.ds.merkletree.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MerkleRootTest {
    private static final String BITCOIN_BLOCK_170_FILENAME = "BitcoinBlock170TXs.txt";
    private static final String BITCOIN_BLOCK_286819_FILENAME = "BitcoinBlock286819TXs.txt";

    private MerkleRoot instance;

    @BeforeEach
    void setUp() {
        instance = new MerkleRoot();
    }

    @Test
    void findMerkleRoot_Block170Transactions_ReturnsTheMerkleRoot() {
        ArrayList<String> blockTxList = FileUtils.getResourceFileAsString(BITCOIN_BLOCK_170_FILENAME);
        assertEquals(2, blockTxList.size());
        String root = instance.findMerkleRoot(blockTxList);
        assertNotNull(root);
        assertEquals("7dac2c5666815c17a3b36427de37bb9d2e2c5ccec3f8633eb91a4205cb4c10ff", root);
    }

    @Test
    void findMerkleRoot_Block286819Transactions_ReturnsTheMerkleRoot() {
        ArrayList<String> blockTxList = FileUtils.getResourceFileAsString(BITCOIN_BLOCK_286819_FILENAME);
        assertEquals(99, blockTxList.size());
        String root = instance.findMerkleRoot(blockTxList);
        assertNotNull(root);
        assertEquals("871714dcbae6c8193a2bb9b2a69fe1c0440399f38d94b3a0f1b447275a29978a", root);
    }
}