package com.insignia.binaryTree;

import java.util.Stack;

public class Constructor {

    public static class Pair{
        int state;
        BinaryNode node;

        Pair(BinaryNode node,int state){
            this.node=node;
            this.state=state;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] { 50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1 };
        Stack<Pair> stack = new Stack<>();
        BinaryNode root = new BinaryNode();

        for (int index = 0; index < input.length; index++) {
            if (stack.isEmpty()) {
                root.data = input[index];
                Pair pair = new Pair(root,0);
                stack.push(pair);
            } else if (input[index] == -1) {
                if (stack.peek().state == 1) {
                    stack.pop();
                } else if(stack.peek().state==0){
                    stack.peek().state+=1;
                }

            } else {
                if (stack.peek().state == 0) {
                    stack.peek().node.left = new BinaryNode(input[index], null, null);
                    stack.peek().state+=1;
                } else {
                    stack.peek().node.right = new BinaryNode(input[index], null, null);
                    stack.peek().state+=1;
                }
            }

        }
    }

}
