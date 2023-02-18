package com.insignia.stackAndQueueLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingInStream {

    public static String firstNonRepeatingInStream(String a) {
        Queue<String> answer = new ArrayDeque<>();
        Map<Character,Boolean> isPresent = new HashMap<>();

        char[] input = a.toCharArray();

        StringBuilder output = new StringBuilder();
        output.append(input[0]);

        answer.add(String.valueOf(input[0]));
        isPresent.put(input[0], true);

        int index = 1;

        while(index!=input.length){
            if(isPresent.containsKey(input[index])){
                if(answer.contains(String.valueOf(input[index]))){
                    answer.remove(String.valueOf(input[index]));
                }

            }else{
                isPresent.put(input[index], true);
                answer.add(String.valueOf(input[index]));
            }

            if(answer.isEmpty()){
                output.append("#");
            }else{
                output.append(answer.peek());
            }

            index+=1;
        }

        return output.toString();
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();

            System.out.println(firstNonRepeatingInStream(input));
        }
    }
}