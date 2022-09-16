package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TilingWith2By1Tiles  {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int fw = Integer.parseInt(reader.readLine());

            int[] tilingWays = new int[fw + 1];
           
            tilingWays[1] = 1;
            tilingWays[2] = 2;

            for (int i = 3; i < fw + 1; i++) {
                // we can place first tile horizontally or vertically , if placed horizontally, we have n-2 area to tile
                // if place vertically we have n-1 area to tile
                tilingWays[i] = tilingWays[i-1] + tilingWays[i-2];    
            }

            System.out.println(tilingWays[fw]);
        }
    }
}
