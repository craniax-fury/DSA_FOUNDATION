package com.insignia.trees.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class DistanceBwNodes {

    public static void display(TreeNode node) {
        System.out.print(node.data + " -> ");

        for (TreeNode child : node.children) {
            System.out.print(child.data + ", ");
        }

        System.out.println(".");

        for (TreeNode child : node.children) {
            display(child);
        }
    }

    public static ArrayList<Integer> nodeToRootPath(TreeNode node, int data){
        
        if(node.data==data){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        ArrayList<Integer> path = new ArrayList<>();

        for(TreeNode child: node.children){        
            path = nodeToRootPath(child, data);
            if(!path.isEmpty()){
                path.add(node.data);
                return path;
            }
        }

        return path;
    }

    public static int lca(TreeNode node, int d1, int d2) {
        ArrayList<Integer> d1Path = nodeToRootPath(node, d1);
        ArrayList<Integer> d2Path = nodeToRootPath(node, d2);

        int i=d1Path.size()-1;
        int j=d2Path.size()-1;

        while(i>=0 && j>=0 && d1Path.get(i)==d2Path.get(j)){
            i--;
            j--;
        }

        return d2Path.get(j+1);

    }

    public static int distanceBetweenNodes(TreeNode node, int d1, int d2){
        ArrayList<Integer> d1Path = nodeToRootPath(node, d1);
        ArrayList<Integer> d2Path = nodeToRootPath(node, d2);

        int i=d1Path.size()-1;
        int j=d2Path.size()-1;

        while(i>=0 && j>=0 && d1Path.get(i)==d2Path.get(j)){
            i--;
            j--;
        }

        if(i>=0 && j>=0){
            return i+1+j+1;
        }
        else if(i>=0){
            return i+1;
        }else
            return j+1;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40,
                    100, -1, -1, -1 };

            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode();

            for (int index = 0; index < input.length; index++) {
                if (input[index] == -1) {
                    stack.pop();
                } else if (stack.size() == 0) {
                    root.data = input[index];
                    stack.push(root);
                } else {
                    TreeNode node = new TreeNode();
                    node.data = input[index];
                    stack.peek().children.add(node);
                    stack.push(node);
                }
            }

            display(root);
            System.out.println("___________________________");

            int d1 = Integer.parseInt(reader.readLine());
            int d2 = Integer.parseInt(reader.readLine());

            int dist = distanceBetweenNodes(root, d1, d2);
            System.out.println(dist);

        }

    }
}
