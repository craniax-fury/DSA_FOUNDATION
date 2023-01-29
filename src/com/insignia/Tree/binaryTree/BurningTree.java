package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BurningTree {

    public static void burnTree(BinaryTreeNode node, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<BinaryTreeNode> stack = new Stack<>();

        if (node == null) {
            return;
        }

        stack.push(node);

        while (!stack.isEmpty()) {
            BinaryTreeNode ele = stack.pop();

            if (ele.right != null) {
                List<Integer> rightList = new ArrayList<>(){
                    {
                        add(ele.data);
                    }
                };

                if (map.containsKey(ele.data)) {
                    List<Integer> eL = map.get(ele.data);
                    eL.add(ele.right.data);
                    map.put(ele.data, eL);
                    map.put(ele.right.data, rightList);
                
                } else {
                    List<Integer> eL = new ArrayList<>();
                    eL.add(ele.right.data);
                    map.put(ele.data, eL);
                    map.put(ele.right.data, rightList);
                }

                stack.push(ele.right);

            }

            if (ele.left != null) {
                List<Integer> lefList = new ArrayList<>(){
                    {
                        add(ele.data);
                    }
                };

                if (map.containsKey(ele.data)) {
                    List<Integer> eL = map.get(ele.data);
                    eL.add(ele.left.data);
                    map.put(ele.data, eL);
                    map.put(ele.left.data, lefList);
                } else {
                    List<Integer> eL = new ArrayList<>();
                    eL.add(ele.left.data);
                    map.put(ele.data, eL);
                    map.put(ele.left.data, lefList);
                }

                stack.push(ele.left);
            }
        }

        int minTimeToBurn = 0;

        List<Integer> connections = map.remove(target);

        while(!map.isEmpty()){

            List<Integer> subConn = new ArrayList<>();

            for(int index=connections.size()-1;index>=0;index--){
                if(map.get(connections.get(index))!=null){
                    subConn.addAll(map.remove(connections.get(index)));
                }

                connections.remove(connections.get(index));

            }

            connections.addAll(subConn);

            minTimeToBurn+=1;

        }

        System.out.println(minTimeToBurn);

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

            int target = Integer.parseInt(reader.readLine());

            BinaryTreeNode root = Constructor.constructor(arr);
            BurningTree.burnTree(root, target);
        }
    }
}
