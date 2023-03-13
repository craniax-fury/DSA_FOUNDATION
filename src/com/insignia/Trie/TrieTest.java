package com.insignia.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrieNode {
    Character data;
    TrieNode[] children;
    boolean isTerminal;

    TrieNode(Character data, boolean isTerminal) {
        this.data = data;
        this.isTerminal = isTerminal;
        children = new TrieNode[26];
    }
}

public class TrieTest {
    public TrieNode root;

    TrieTest() {
        root = new TrieNode(null, false);
    }

    public void insert(String word) {

        char[] chars = word.toCharArray();

        TrieNode tempNode = root;

        boolean isTerminal = false;

        for (int index = 0; index < word.length(); index++) {
            if (index == word.length() - 1) {
                isTerminal = true;
            }

            char insertMe = chars[index];

            int pos = insertMe - 'a';

            TrieNode child = tempNode.children[pos];

            if (child == null) {
                TrieNode node = new TrieNode(insertMe, isTerminal);
                tempNode.children[pos] = node;
                tempNode = node;

            } else {
                if (isTerminal) {
                    child.isTerminal = true;
                    return;
                }

                tempNode = child;
            }
        }

    }

    public boolean search(String word) {

        char[] chars = word.toCharArray();

        TrieNode tempNode = root;

        for (int index = 0; index < word.length(); index++) {
            char searchMe = chars[index];

            int pos = searchMe - 'a';

            TrieNode child = tempNode.children[pos];

            if (child == null) {
                return false;

            } else if (index == word.length() - 1 && !child.isTerminal) {
                return false;

            } else if (index != word.length() - 1 && child.isTerminal) {
                return false;

            } else if (index == word.length() - 1) {
                return true;

            } else {
                tempNode = child;
            }
        }

        return false;

    }

    public boolean remove(String word) {

        TrieNode tempNode = root;

        char[] chars = word.toCharArray();

        for (int index = 0; index < word.length(); index++) {
            char findMe = chars[index];

            int pos = findMe - 'a';

            TrieNode child = tempNode.children[pos];

            if (child == null) {
                return false;

            } else if (index == word.length() - 1 && !child.isTerminal) {
                return false;

            } else if (index != word.length() - 1 && child.isTerminal) {
                return false;

            } else if (index == word.length() - 1) {
                child.isTerminal = false;

            } else {
                tempNode = child;
            }
        }

        return true;

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] cmds = new String[] { "Trie", "insert", "search", "search", "remove", "startsWith", "remove",
                    "search" };
            String[] input = new String[] { "", "apple", "apple", "app", "app", "app", "apple", "apple" };

            TrieTest obj = null;

            for (int index = 0; index < input.length; index++) {

                if (cmds[index].equals("Trie")) {
                    obj = new TrieTest();

                } else if (cmds[index].equals("insert")) {
                    obj.insert(input[index]);

                } else if (cmds[index].equals("search")) {
                    System.out.println(obj.search(input[index]));

                } else if (cmds[index].equals("startsWith")) {
                    // System.out.println(obj.startsWith(input[index]));

                } else if (cmds[index].equals("remove")) {
                    System.out.println(obj.remove(input[index]));

                } else {
                    System.out.println("incorrect command");
                }
            }
        }
    }
}
