package com.insignia.Trie;

public class LongestCommonPrefix2 {

    public static void main(String[] args) {
        //String[] input = new String[] { "flower","flow", "flight" };
        String[] input = new String[] {"a","ab","c"};

        StringBuilder ans = new StringBuilder();
        
        int ll = input[0].length();
        TrieStruct obj = new TrieStruct();

        obj.insert(input[0]);

        for (int index=1;index<input.length;index++) {
            TrieEle tempNode = obj.root;
           
            ans = new StringBuilder();

            char[] chars = input[index].toCharArray();

            for(int in=0;in<ll && in<input[index].length();in++){
                int pos = chars[in] - 'a';

                TrieEle child = tempNode.children[pos];

                if(child == null){
                    if(in==0){
                       ll=0;
                       System.out.println(ans);
                       return; 
                    }

                    ll=in+1;
                    break;
                
                }else{
                    ans.append(child.data);
                    tempNode = child;
                } 
            }

            if(index==input.length-1){
                System.out.println(ans);
            }
        }
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