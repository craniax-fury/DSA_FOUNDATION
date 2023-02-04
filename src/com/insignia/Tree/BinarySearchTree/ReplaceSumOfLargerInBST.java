package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceSumOfLargerInBST {

    private static int sum = 0;
    public static void replaceSumOfLarger(BSTNode node) {
        if (node == null) {
            return;
        }

        replaceSumOfLarger(node.right);
        
        int temp = node.data;
        node.data=sum;
        sum+=temp;

        replaceSumOfLarger(node.left);
        
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            Integer[] arr = new Integer[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                if (!(values[index].equals("n"))) {
                    arr[index] = Integer.parseInt(values[index]);
                } else {
                    arr[index] = null;
                }
            }

            BSTNode root = Constructor.constructor(arr);
            replaceSumOfLarger(root);

        }
    }
}
