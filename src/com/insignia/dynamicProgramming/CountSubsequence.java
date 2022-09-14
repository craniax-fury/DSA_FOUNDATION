package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubsequence {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            char[] ic = input.toCharArray();

            int[] aP = new int[ic.length];
            int[] aPbP = new int[ic.length];
            int[] aPbPcP = new int[ic.length];

            for (int i = 0; i < ic.length; i++) {
                if (ic[i] == 'a') {
                    if (i - 1 >= 0) {
                        aPbP[i] = aPbP[i - 1];
                        aPbPcP[i] = aPbPcP[i - 1];
                        aP[i] = 2 * aP[i - 1] + 1; // can interact with old ones in two ways i.e. can or cannot append,
                                                   // and can start its own string in one way for a+ type
                    } else {
                        aP[i] = 1;
                    }

                } else if (ic[i] == 'b' && i - 1 >= 0) {
                    aP[i] = aP[i - 1];
                    aPbPcP[i] = aPbPcP[i - 1];
                    aPbP[i] = aP[i - 1] + 2 * aPbP[i - 1]; // can interact with old ones in two ways i.e. can or cannot
                                                           // append,
                                                           // can append itself to a+ types
                } else if (ic[i] == 'c' && i - 1 >= 0) {
                    aP[i] = aP[i - 1];
                    aPbP[i] = aPbP[i - 1];
                    aPbPcP[i] = aPbP[i - 1] + 2 * aPbPcP[i - 1]; // can interact with old ones in two ways i.e. can or
                                                                 // cannot append,
                                                                 // can append itself to a+b+ types
                }
            }

            System.out.println(aPbPcP[ic.length - 1]);
        }
    }
}
