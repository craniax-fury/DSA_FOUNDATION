package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PrintKPC {

    public static Map<String, String> kmapping = new HashMap<>();

    public static void printKpc(String str,String asf) {

        //base case
        if(str.equals("")){
            System.out.println(asf);
            return;
        }

        // processing
        String first = String.valueOf(str.charAt(0));

        char[] keychars = kmapping.get(first).toCharArray();

        //recursive call
        for(char keychar : keychars){
            printKpc(str.substring(1), asf+String.valueOf(keychar));
        }
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

        char[] chars = input.toCharArray();
        
        for(char character: chars){
            kmapping.get(String.valueOf(character));
        }

        printKpc(input,"");

    }

}