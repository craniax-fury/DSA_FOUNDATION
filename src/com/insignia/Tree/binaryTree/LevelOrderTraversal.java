package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrderTraversal(BinaryTreeNode node) {

        Queue<BinaryTreeNode> queue = new ArrayDeque<>();

        queue.add(node);

        BinaryTreeNode dummy = new BinaryTreeNode();
        dummy.data = -1;

        queue.add(dummy);

        while (!queue.isEmpty() && !(queue.size() == 1 && queue.peek().data == dummy.data)) {
            BinaryTreeNode main = queue.remove();

            if (main.data == dummy.data) {
                queue.add(dummy);
                System.out.println();

            } else {

                System.out.print(main.data+" ");
                
                if (main.left != null) {
                    queue.add(main.left);
                }
                if (main.right != null) {
                    queue.add(main.right);
                }
            }

        }
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
            LevelOrderTraversal.levelOrderTraversal(root);
        }
    }
}
