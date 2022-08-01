package com.insignia.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeyMapping {

    static Map<Integer, String> keyMapping = new HashMap<>() {
        {
            put(0, ".;");
            put(1, "abc");
            put(2, "def");
            put(3, "ghi");
            put(4, "jkl");
            put(5, "mno");
            put(6, "pqrs");
            put(7, "tu");
            put(8, "vwx");
            put(9, "yz");
        }
    };

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String input = br.readLine();

            ArrayList<String> output = getKPC(input);

            System.out.print(output);
        }
    }

    public static ArrayList<String> getKPC(String str) {
        
        if(str.length()==1){
            ArrayList<String> tmpOut = new ArrayList<>();

            for(Character character:keyMapping.get(str.charAt(0)-'0').toCharArray()){
                tmpOut.add(character.toString());
            }

            return tmpOut;
        }

        Character first = str.charAt(0);

        ArrayList<String> tmpOutput = getKPC(str.substring(1));

        ArrayList<String> output = new ArrayList<>();

        for(Character character: keyMapping.get(first-'0').toCharArray()){
            
            for(int index=0;index<tmpOutput.size();index++){
                output.add(character.toString()+tmpOutput.get(index));
            }
        }

        return output;
    }

}