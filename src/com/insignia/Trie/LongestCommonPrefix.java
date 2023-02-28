package com.insignia.Trie;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        //String[] input = new String[] { "flower", "flow", "flight" };
        String[] input = new String[] { "ab", "a" };

        StringBuilder ans = new StringBuilder();

        TrieStruct obj = new TrieStruct();

        for (String in : input) {
            obj.insert(in);
        }

        String first = input[0];
        
        TrieEle tempNode = obj.root;

        for (char ch : first.toCharArray()) {

            if (tempNode.childCount == 1 && !tempNode.isTerminal) {
                ans.append(ch);
                int pos = ch - 'a';
                tempNode = tempNode.children[pos];
            }else{
                break;
            }
        }

        System.out.println(ans);
    }
}

class TrieEle {
    Character data;
    TrieEle[] children;
    boolean isTerminal;
    int childCount;

    TrieEle() {
        children = new TrieEle[26];
    }

    TrieEle(Character data, boolean isTerminal) {
        this.data = data;
        this.isTerminal = isTerminal;
        children = new TrieEle[26];
    }
}

class TrieStruct {
    TrieEle root;

    TrieStruct() {
        root = new TrieEle();
    }

    void insert(String word) {
        char[] chars = word.toCharArray();

        if(chars.length==0){
            root.isTerminal = true;
        }

        TrieEle tempNode = root;

        for (int index = 0; index < chars.length; index++) {

            int pos = chars[index] - 'a';

            TrieEle child = tempNode.children[pos];

            boolean isTerminal = false;

            if (index == chars.length - 1) {
                isTerminal = true;
            }

            if (child == null) {
                child = new TrieEle(chars[index], isTerminal);
                tempNode.children[pos] = child;
                tempNode.childCount += 1;
                tempNode = child;
            } else {
                if (isTerminal) {
                    child.isTerminal = isTerminal;
                }

                tempNode = child;

            }
        }
    }
}