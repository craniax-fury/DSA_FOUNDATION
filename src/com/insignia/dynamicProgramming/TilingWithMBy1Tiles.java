package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TilingWithMBy1Tiles  {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int fw = Integer.parseInt(reader.readLine());
            int fl = Integer.parseInt(reader.readLine());

            if(fl>fw){ // tile width is greater than floor width then we can only place each tile vertically
                System.out.println(1);
                return;
            }

            int[] tilingWays = new int[fw + 1];
           
            for(int i=1;i<fl;i++){
                tilingWays[i] = 1;
            }

            tilingWays[fl] = 2;

            for (int i = fl+1; i < fw + 1; i++) {
                // we can place first tile horizontally or vertically , if placed horizontally, we have n-2 area to tile
                // if place vertically we have n-1 area to tile
                tilingWays[i] = tilingWays[i-1] + tilingWays[i-fl];    
            }

            System.out.println(tilingWays[fw]);
        }
    }
}
