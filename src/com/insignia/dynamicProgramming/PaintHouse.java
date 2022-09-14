package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaintHouse {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int noh = Integer.parseInt(reader.readLine());

            int[] r = new int[noh];
            int[] g = new int[noh];
            int[] b = new int[noh];

            for (int i = 0; i < noh; i++) {
                String[] costs = reader.readLine().split(" ");  
                r[i]=Integer.parseInt(costs[0]);
                g[i]=Integer.parseInt(costs[1]);
                b[i]=Integer.parseInt(costs[2]);
                
            }

            int[] rMin = new int[noh];
            int[] gMin = new int[noh];
            int[] bMin = new int[noh];

            rMin[0] = r[0];
            gMin[0] = g[0];
            bMin[0] = b[0];
            
            for(int i=1;i<noh;i++){
                rMin[i] = r[i] + Math.min(gMin[i-1], bMin[i-1]);
                gMin[i] = g[i] + Math.min(rMin[i-1], bMin[i-1]);
                bMin[i] = b[i] + Math.min(gMin[i-1], rMin[i-1]);

            }

            System.out.println(Math.min(Math.min(rMin[noh-1],gMin[noh-1]),bMin[noh-1]));
        }
    }
}
