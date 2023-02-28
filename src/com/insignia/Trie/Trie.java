package com.insignia.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrieNode {
    Character data;
    TrieNode[] children = new TrieNode[26];
    boolean isTerminal;

    public TrieNode() {

    }

    public TrieNode(Character data, boolean isTerminal) {
        this.data = data;
        this.isTerminal = isTerminal;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();

        TrieNode tempNode = root;

        for (int index = 0; index < chars.length; index++) {
 
            int pos = chars[index] - 'a';

            TrieNode child = tempNode.children[pos];

            boolean isTerminal = false;

            if (index == chars.length - 1) {
                isTerminal = true;
            }

            if (child == null) {
                child = new TrieNode(chars[index], isTerminal);
                tempNode.children[pos] = child;
                tempNode = child;
            } else {
                if(isTerminal){
                    child.isTerminal = isTerminal;    
                }

                tempNode = child;
            }
        }
    }

    public boolean search(String word) {

        char[] chars = word.toCharArray();

        TrieNode tempNode = root;

        for (int index = 0; index < chars.length; index++) {

            int pos = chars[index] - 'a';

            TrieNode child = tempNode.children[pos];

            if (child == null) {
                return false;

            } else if (child.data != chars[index]) {
                return false;

            } else {
                tempNode = child;
            }

            if (index == chars.length - 1 && !tempNode.isTerminal) {
                return false;
            }
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();

        TrieNode tempNode = root;

        for (int index = 0; index < chars.length; index++) {

            int pos = chars[index] - 'a';

            TrieNode child = tempNode.children[pos];

            if (child == null) {
                return false;

            } else if (child.data != chars[index]) {
                return false;

            } else {
                tempNode = child;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] cmds = new String[]{"Trie", "insert", "search", "search", "startsWith","search","insert", "search"};
            String[] input = new String[]{"", "apple", "apple", "app", "app", "app", "app","app"};

            Trie obj = null;
           
            for(int index=0;index<input.length;index++){
    
                if(cmds[index].equals("Trie")){
                   obj = new Trie();
                
                } else if(cmds[index].equals("insert")){
                    obj.insert(input[index]);
                
                } else if(cmds[index].equals("search")){
                    System.out.println(obj.search(input[index]));

                } else if(cmds[index].equals("startsWith")){
                    System.out.println(obj.startsWith(input[index]));
                    
                } else {
                    System.out.println("incorrect command");
                }
            }
        }
        
    }
}