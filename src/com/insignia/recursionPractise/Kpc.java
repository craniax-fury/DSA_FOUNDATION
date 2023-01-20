package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kpc {
    static Map<String, String> keys = new HashMap<>() {
        {
            put("0", ".;");
            put("1", "abc");
            put("2", "def");
            put("3", "ghi");
            put("4", "jkl");
            put("5", "mno");
            put("6", "pqrs");
            put("7", "tu");
            put("8", "vwx");
            put("9", "yz");
        }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        ArrayList<String> ss = kpc(n);
        System.out.print(ss);
    }

    private static ArrayList<String> kpc(String str) {
        if(str.length()==1){
            String poss = keys.get(str);
            
            ArrayList<String> strings = new ArrayList<>();

            for(int i=0;i<poss.length();i++){
                strings.add(String.valueOf(poss.charAt(i)));
            }

            return strings;
        }

        String first = keys.get(String.valueOf(str.charAt(0)));
        ArrayList<String> poss = kpc(str.substring(1));
        ArrayList<String> out = new ArrayList<>();

        for(int i=0;i<first.length();i++){
            for(String s:poss){
                out.add(String.valueOf(first.charAt(i))+s);
            } 
        }

        return out;
    }
}