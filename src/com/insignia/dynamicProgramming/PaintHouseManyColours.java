package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaintHouseManyColours {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int noh = Integer.parseInt(input[0]);
            int noc = Integer.parseInt(input[1]);

            int[][] costMatrix = new int[noh][noc];

            for (int i = 0; i < noh; i++) {
                String[] colorCost = reader.readLine().split(" ");
                for (int j = 0; j < noc; j++) {
                    costMatrix[i][j] = Integer.parseInt(colorCost[j]);
                }
            }

            int[][] minCostMatrix = new int[noc][noh];

            for (int i = 0; i < noc; i++) {
                minCostMatrix[i][0] = costMatrix[0][i];
            }

            for (int i = 1; i < noh; i++) {
                for (int j = 0; j < noc; j++) {
                    int minCostForPrevChoices = getMinCostForJthColor(minCostMatrix, noc, i-1, j);
                    minCostMatrix[j][i] = minCostForPrevChoices + costMatrix[i][j];
                }

            }

            System.out.println(getMinCost(minCostMatrix, noc, noh - 1));
        }
    }

    private static int getMinCost(int[][] minCostMatrix, int noc, int hNo) {
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < noc; i++) {
            if (minCostMatrix[i][hNo] < minCost) {
                minCost = minCostMatrix[i][hNo];
            }
        }

        return minCost;
    }

    private static int getMinCostForJthColor(int[][] minCostMatrix, int noc, int hNo, int colour) {
        int minCostForPrevChoices = Integer.MAX_VALUE;
        for (int i = 0; i < noc; i++) {
            if (i != colour && minCostMatrix[i][hNo] < minCostForPrevChoices) {
                minCostForPrevChoices = minCostMatrix[i][hNo];
            }
        }

        return minCostForPrevChoices;
    }
}
