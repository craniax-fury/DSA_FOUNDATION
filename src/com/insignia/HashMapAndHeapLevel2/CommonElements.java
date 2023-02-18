package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<Integer,Integer> n1Map = new HashMap<>();

            int n1 = Integer.parseInt(reader.readLine());
            
            for(int i=0;i<n1;i++){
                n1Map.merge(Integer.parseInt(reader.readLine()),1,Integer::sum);
            }

            int n2 = Integer.parseInt(reader.readLine());

            for(int i=0;i<n2;i++){
                int a2 = Integer.parseInt(reader.readLine());
                Integer n1Value =n1Map.get(a2);

                if(n1Value!=null && n1Value>0){
                   n1Map.put(a2,n1Value-1);
                   System.out.println(a2);
                }    
            }
        }
    }
}
