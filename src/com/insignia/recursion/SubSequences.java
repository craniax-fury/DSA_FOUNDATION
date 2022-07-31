package com.insignia.recursion;

import java.io.*;
import java.util.ArrayList;

public class SubSequences {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            ArrayList<String> output = gss(input);

            for (String out : output) {
                System.out.print(out + " ");
            }
        }

    }

    public static ArrayList<String> gss(String str) {

        if (str.length() == 0) {
            ArrayList<String> out = new ArrayList<>();
            out.add("");
            return out;
        }

        String first = String.valueOf(str.charAt(0));
        ArrayList<String> subSeq1 = gss(str.substring(1));

        ArrayList<String> tempOutput = new ArrayList<>();

        for (String string : subSeq1) {
            tempOutput.add(string);
        }

        for (String string : subSeq1) {
            tempOutput.add(first + string);
        }
        return tempOutput;
    }

}