package com.insignia.hashMapAndHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequence {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<Integer,Integer> n1Map = new HashMap<>();

            int n1 = Integer.parseInt(reader.readLine());
            
            for(int i=0;i<n1;i++){
                n1Map.merge(Integer.parseInt(reader.readLine()),1,Integer::sum);
            }

            int lcsl = 0;
            List<Integer> ele = new ArrayList<>();

            for(Map.Entry<Integer,Integer> entry : n1Map.entrySet()){
                int subLcsl = 0;
                int startsWith = entry.getKey();
                List<Integer> subEle = new ArrayList<>();

                while(n1Map.containsKey(startsWith)){
                    subLcsl++;
                    subEle.add(startsWith);
                    startsWith--;
                }
               
                if(subLcsl>lcsl){
                    lcsl=subLcsl;
                    ele=subEle;
                }
            }

            for(int i=ele.size()-1;i>=0;i--){
                System.out.println(ele.get(i));
            }
        }
    }
}
