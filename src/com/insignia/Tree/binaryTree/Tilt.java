package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tilt {

    public static int tilt(BinaryTreeNode node) {
        int leftTilt = 0;
        int rightTilt = 0;

        int leftSum=0;
        int rightSum=0;

        if (node == null) {
            return 0;
        }

        if (node.left != null) {
            leftSum = sum(node.left);
            leftTilt = tilt(node.left);
        }

        if (node.right != null) {
            rightSum = sum(node.right);
            rightTilt = tilt(node.right);
        }


        return Math.abs(leftSum - rightSum) + leftTilt + rightTilt;
    }

    private static int sum(BinaryTreeNode node) {
        int sum=0;

        if(node==null){
            return 0;
        }

        sum+=sum(node.left);
        sum+=sum(node.right);

        return sum+node.data;
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

            BinaryTreeNode root = Constructor.constructor(arr);
            System.out.println(Tilt.tilt(root));
        }
    }
}
