package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecodeWays {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            char[] ic = input.toCharArray();

            int[] out = new int[ic.length];

            if (ic.length > 1) {
                if (ic[0] - '0' != 0) {
                    out[0] = 1;
                }

                if (ic[0] - '0' == 0 && ic[1] - '0' != 0) {
                    out[1] = 1;
                } else if (ic[0] - '0' != 0 && ic[0] - '0' <= 2 && ic[1] - '0' <= 6) {
                    out[1] = 2;
                } else if (ic[1] - '0' != 0) {
                    out[1] = 1;
                }
            } else {
                if (ic[0] - '0' != 0) {
                    out[0] = 1;
                }
            }

            for (int i = 2; i < ic.length; i++) {

                if (ic[i - 1] - '0' == 0 && ic[i] - '0' == 0) {
                    out[i] = 0;
                }

                if (ic[i - 1] - '0' != 0 && ic[i - 1] - '0' <= 2 && ic[i] - '0' == 0) {
                    out[i] += out[i - 1];
                }

                if (ic[i - 1] - '0' == 0 && ic[i] - '0' != 0) {
                    out[i] = 0;
                }

                if (ic[i - 1] - '0' != 0 && ic[i] - '0' != 0) {
                    out[i] += out[i - 1];
                }

                if (ic[i - 1] - '0' != 0 && ic[i - 1] - '0' <= 2 && ic[i] - '0' != 0 && ic[i] - '0' <= 6) {
                    out[i] += out[i - 2];
                }

            }

            System.out.println(out[ic.length - 1]);
        }
    }
}
