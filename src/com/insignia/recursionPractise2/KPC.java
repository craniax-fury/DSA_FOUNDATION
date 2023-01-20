package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KPC {

    public static Map<String, String> kmapping = new HashMap<>();

    public static ArrayList<String> getKpc(String str) {

        ArrayList<String> out = new ArrayList<>();

        // base case
        if(str.length()==1){
            char[] kMapp = kmapping.get(str).toCharArray();

            for(char character:kMapp){
                out.add(String.valueOf(character));
            }

            return out;
        }

        String first = String.valueOf(str.charAt(0));

        ArrayList<String> strings = getKpc(str.substring(1));

        char[] kMapp = kmapping.get(first).toCharArray();
        
        for(char character: kMapp){
            for(String string:strings){
                out.add(String.valueOf(character)+string);
            }
        }
        
        return out;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        kmapping.put("0", ".;");
        kmapping.put("1", "abc");
        kmapping.put("2", "def");
        kmapping.put("3", "ghi");
        kmapping.put("4", "jkl");
        kmapping.put("5", "mno");
        kmapping.put("6", "pqrs");
        kmapping.put("7", "tu");
        kmapping.put("8", "vwx");
        kmapping.put("9", "yz");

        String input = br.readLine();
        
        System.out.println(getKpc(input));

    }

}