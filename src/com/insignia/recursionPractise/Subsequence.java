package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Subsequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
    
        ArrayList<String> ss = getSS(n);
        System.out.print(ss);
    }

    private static ArrayList<String> getSS(String str) {
        if(str.length()==0){
            ArrayList<String> ss = new ArrayList<>();
            ss.add("");
            return ss; 
        }
        
        String first = String.valueOf(str.charAt(0));
        ArrayList<String> ss = getSS(str.substring(1));
       
        ArrayList<String> output = new ArrayList<>();
        
        for(int i=0;i<ss.size();i++){
            output.add(ss.get(i));
            output.add(first + ss.get(i));
        }

        return output;
    }
}