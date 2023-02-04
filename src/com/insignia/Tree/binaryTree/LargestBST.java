package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static class LBPair {
        boolean isBST;
        int data;
        int nodes;
        int min;
        int max;

        LBPair(boolean isBST, int data, int nodes, int min, int max) {
            this.isBST = isBST;
            this.data = data;
            this.nodes = nodes;
            this.min = min;
            this.max = max;
        }

    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    static LBPair finalPair = new LBPair(false, 0, 0, 0, 0);

    private static LBPair largestBST(Node node) {

        int nodes = 0;
        int data = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if (node == null) {
            return new LBPair(true, 0, 0, min, max);
        }

        LBPair lpair = largestBST(node.left);

        if (!lpair.isBST) {
            return new LBPair(false, data, nodes, min, max);
        }

        LBPair rpair = largestBST(node.right);

        if (!rpair.isBST) {
            return new LBPair(false, data, nodes, min, max);
        }

        if (lpair.isBST && lpair.nodes > nodes) {
            nodes = lpair.nodes;
            data = lpair.data;
        }

        if (rpair.isBST && rpair.nodes > nodes) {
            nodes = rpair.nodes;
            data = rpair.data;
        }

        if (lpair.isBST && rpair.isBST && lpair.max < node.data && rpair.min > node.data) {
            data = node.data;
            nodes = lpair.nodes + rpair.nodes + 1;

            if (node.data < Math.min(lpair.min, rpair.min)) {
                min = node.data;
            } else {
                min = Math.min(lpair.min, rpair.min);
            }

            if (node.data > Math.max(lpair.max, rpair.max)) {
                max = node.data;
            } else {
                max = Math.max(lpair.max, rpair.max);
            }

            if (finalPair.nodes < nodes) {
                finalPair.isBST=true;
                finalPair.nodes = nodes;
                finalPair.data = data;
            }

            return new LBPair(true, data, nodes, min, max);
        } else {
            return new LBPair(false, data, nodes, min, max);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        LargestBST.largestBST(root);
        System.out.println(finalPair.isBST?finalPair.data + "@" + finalPair.nodes:0+"@"+0);
    }

}