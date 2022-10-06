package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PrintKpc {
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

        printKpc(n,"");
    }

    private static void printKpc(String str,String out) {
        if(str.length()==1){
            String poss = keys.get(str);

            for(int i=0;i<poss.length();i++){
               System.out.println(out+String.valueOf(poss.charAt(i)));
            }
            return;
        }

        String first = keys.get(String.valueOf(str.charAt(0)));

        for(int i=0;i<first.length();i++){
            printKpc(str.substring(1),out+String.valueOf(first.charAt(i)));
        }
    }
}