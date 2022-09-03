package com.insignia.hashMapAndHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HighestFreqChar {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();

            Map<Character, Integer> freqMap = new HashMap<>();
            char[] chars = input.toCharArray();

            for (Character ch : chars) {
                freqMap.merge(ch, 1, Integer::sum);
            }

            // int maxFreq = freqMap.entrySet().stream().map(ch -> ch.getValue()).max(Comparator.naturalOrder()).get();

            // System.out.println(freqMap.entrySet().stream().filter(ch -> ch.getValue()==maxFreq).findFirst().get().getKey());

            char mfc = chars[0];
            int mfv = freqMap.get(mfc);
            
            for(Map.Entry<Character,Integer> entry: freqMap.entrySet()){
                if(entry.getValue()>mfv){
                    mfv=entry.getValue();
                    mfc=entry.getKey();
                }
            }

            System.out.println(mfc);
        }
    }
}
