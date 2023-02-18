package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/
public class PriorityQueueUsingHeap {

    ArrayList<Integer> data;

    public PriorityQueueUsingHeap() {
        this.data = new ArrayList<>();
    }

    // log(n), upHeapify to maintain hop
    public void add(int val) {

        data.add(val);

        upHeapify(data, data.size() - 1);
    }

    private void upHeapify(ArrayList<Integer> data, int childIndex) {

        if (childIndex <= 0) {
            return;
        }

        int parent = (childIndex - 1) / 2;

        if (data.get(childIndex) < data.get(parent)) {
            int temp = data.get(parent);
            data.set(parent, data.get(childIndex));
            data.set(childIndex, temp);
        } else {
            return;
        }

        upHeapify(data, parent);
    }

    public int remove() {
        if (data.size() == 0) {
            return -1;
        }

        int temp = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.set(data.size() - 1, temp);

        int ans = data.remove(data.size() - 1);

        downHeapify(0);

        return ans;
    }

    private void downHeapify(int parentIndex) {

        int smallerIndex = 0;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;

        if (leftIndex > data.size() - 1 && rightIndex > data.size() - 1) {
            return;
        } else if (leftIndex > data.size() - 1 && rightIndex < data.size() - 1) {
            smallerIndex = rightIndex;
        } else if (leftIndex < data.size() - 1 && rightIndex > data.size() - 1) {
            smallerIndex = leftIndex;
        } else {
            smallerIndex = data.get(rightIndex) < data.get(leftIndex) ? rightIndex : leftIndex;
        }

        if (data.get(parentIndex) > data.get(smallerIndex)) {

            int temp = data.get(parentIndex);
            data.set(parentIndex, data.get(smallerIndex));
            data.set(smallerIndex, temp);
        } else {
            return;
        }

        downHeapify(smallerIndex);
    }

    public int peek() {
        if (data.size() == 0) {
            return -1;
        }

        return data.get(0);
    }

    public int size() {
        return data.size();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            PriorityQueueUsingHeap queue = new PriorityQueueUsingHeap();

            String str = br.readLine();

            while (str.equals("quit") == false) {
                if (str.startsWith("add")) {
                    String[] input = str.split(" ");
                    int in = Integer.parseInt(input[1]);
                    queue.add(in);

                } else if (str.startsWith("remove")) {
                    int ans = queue.remove();
                    System.out.println(ans == -1 ? "Underflow" : ans);

                } else if (str.startsWith("peek")) {
                    int ans = queue.peek();
                    System.out.println(ans == -1 ? "Underflow" : ans);

                } else if (str.startsWith("size")) {
                    System.out.println(queue.size());
                } else {
                    System.out.println("invalid argument");
                    return;
                }

                str = br.readLine();
            }
        }
    }
}
