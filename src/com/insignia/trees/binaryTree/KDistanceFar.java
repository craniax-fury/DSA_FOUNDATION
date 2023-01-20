package com.insignia.trees.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class KDistanceFar {

    public static class Pair {
        int state;
        BinaryNode node;

        Pair(BinaryNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static class LevelPair {
        int level;
        BinaryNode node;

        LevelPair(BinaryNode node, int level) {
            this.node = node;
            this.level = level;
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

    public static void printKNodesFar(BinaryNode node, int data, int k) {
        
        ArrayList<BinaryNode> path = nodeToRootPath(node,data);

        for(int i=0;i<path.size();i++){
           int blocker = -1;
            
            if(i!=0){
                blocker = path.get(i-1).data;
            }

            printKLevelDown(path.get(i),k,blocker);

            k--;
        }
    }

    private static void printKLevelDown(BinaryNode binaryNode, int k,int blocker) {
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(binaryNode,0));

        while(!stack.isEmpty()){
            Pair tempPair = stack.pop();
            if(tempPair.state==k){
                System.out.println(tempPair.node.data);
            }

            if(tempPair.state<=k){

                if(tempPair.node.right!=null && tempPair.node.right.data!=blocker){
                    stack.push(new Pair(tempPair.node.right,tempPair.state+1));
                }

                if(tempPair.node.left!=null && tempPair.node.left.data!=blocker){
                    stack.push(new Pair(tempPair.node.left,tempPair.state+1));
                }
            }
        }
    }

    static ArrayList<BinaryNode> path  = new ArrayList<>();

    private static ArrayList<BinaryNode> nodeToRootPath(BinaryNode node, int data) {

        if(node.data==data){
            path.add(node);
            return path;
        }

        if(node.left!=null){
           ArrayList<BinaryNode> tempPath =  nodeToRootPath(node.left, data);
            if(tempPath.size()!=0){
                path.add(node);
                return path;
            }
        }

        if(node.right!=null){
            ArrayList<BinaryNode> tempPath =   nodeToRootPath(node.right, data);
            if(tempPath.size()!=0){
                path.add(node);
                return path;
            }
        }

        return path;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

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

            int data = Integer.parseInt(reader.readLine());
            int k = Integer.parseInt(reader.readLine());

            printKNodesFar(root,data,k);
        }
    }
}
