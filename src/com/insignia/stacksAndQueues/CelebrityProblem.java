package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());

            int[][] input = new int[n][n];

            for (int i = 0; i < n; i++) {
                String inputString = sc.nextLine();
                char[] inputArray = inputString.toCharArray();

                for (int j = 0; j < n; j++) {
                    input[i][j] = inputArray[j] - '0';
                }
            }

            Stack<Integer> elements = new Stack<>();

            for (int index = 0; index < n; index++) {
                elements.push(index);
            }

            while (elements.size() > 1) {
                int person1 = elements.pop();
                int person2 = elements.pop();

                if (input[person1][person2] == 1) {
                    elements.push(person2);
                } else {
                    elements.push(person1);
                }
            }

            boolean isCelebrity = true;

            for (int index = 0; index < n; index++) {
                if (input[elements.peek()][index] == 1) {
                    isCelebrity = false;
                    break;
                } else if (index != elements.peek() && input[index][elements.peek()] == 0) {
                    isCelebrity = false;
                    break;
                }
            }

            System.out.println(isCelebrity == true ? elements.peek() : "none");
        }
    }
}
