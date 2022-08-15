package com.insignia.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.RunElement;

public class NodeToRootPath {

    public static class Pair {
        int state;
        BinaryNode node;

        Pair(BinaryNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(BinaryNode root) {
        String left_data = root.left != null ? String.valueOf(root.left.data) : ".";
        String right_data = root.right != null ? String.valueOf(root.right.data) : ".";

        System.out.print(left_data + " -> " + root.data + " <- " + right_data);

        System.out.println();

        if (root.left != null) {
            display(root.left);
        }

        if (root.right != null) {
            display(root.right);
        }
    }

    public static boolean find(BinaryNode node, int data) {

        if (node.data == data) {
            return true;
        }

        if(node.left!=null){
            if(find(node.left, data)){
                return true;
            }
        }

        if(node.right!=null){
            if(find(node.right, data)){
                return true;
            }
        }

        return false;
    }

    static ArrayList<Integer> path = new ArrayList<>();

    public static ArrayList<Integer> nodeToRootPath(BinaryNode node, int data) {
        
        if (node.data==data) {
            path.add(node.data);
            return path;
        }
        
        if (node.left != null) {
            ArrayList<Integer> tempPath = nodeToRootPath(node.left, data);
            if (tempPath.size() != 0) {
                path.add(node.data);
                return path;
            }
        }
        
        if (node.right != null ) {
            ArrayList<Integer> tempPath = nodeToRootPath(node.right, data);
            if (tempPath.size() != 0) {
                path.add(node.data);
                return path;
            }
        }

        if (path.size() != 0) {
            path.add(node.data);
        }

        return path;

    }

    public static void main(String[] args) {
        int[] input = new int[] { 50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1 };
        Stack<Pair> stack = new Stack<>();
        BinaryNode root = new BinaryNode();

        for (int index = 0; index < input.length; index++) {
            if (stack.isEmpty()) {
                root.data = input[index];
                Pair pair = new Pair(root, 0);
                stack.push(pair);
            } else if (input[index] == -1) {
                if (stack.peek().state == 1) {
                    stack.pop();
                } else if (stack.peek().state == 0) {
                    stack.peek().state += 1;
                }

            } else {
                if (stack.peek().state == 0) {
                    BinaryNode left = new BinaryNode(input[index], null, null);
                    stack.peek().node.left = left;
                    stack.peek().state += 1;
                    stack.push(new Pair(left, 0));
                } else {

                    while (!stack.isEmpty() && stack.peek().state == 2) {
                        stack.pop();
                    }

                    BinaryNode right = new BinaryNode(input[index], null, null);
                    stack.peek().node.right = right;
                    stack.peek().state += 1;
                    stack.push(new Pair(right, 0));
                }
            }
        }

        System.out.println(find(root, 30));
        System.out.println(nodeToRootPath(root, 30));

    }

}
