package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.insignia.linkedList.Node;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/

public class MergeKSortedLinkedList {

    public static Node mergeKLL(Node[] arr, int K) {

        Comparator<Node> comparator = new Comparator<>() {

            @Override
            public int compare(Node p1, Node p2) {
                return p1.getData() - p2.getData();
            }
        };

        PriorityQueue<Node> queue = new PriorityQueue<>(comparator);

        Node parent = new Node();

        for (int index = 0; index < K; index++) {
            queue.add(arr[index]);
        }

        parent = queue.poll();

        Node temp = parent;

        if (temp.getNext() != null) {
            queue.add(temp.getNext());
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            temp.setNext(node);

            temp = node;

            if (temp.getNext() != null) {
                queue.add(temp.getNext());
            }
        }

        return parent;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(br.readLine());

            Node[] arr = new Node[k];

            for (int index = 0; index < k; index++) {
                int size = Integer.parseInt(br.readLine());

                Node root = new Node(Integer.parseInt(br.readLine()), null);

                arr[index] = root;

                Node temp = root;

                for (int subIndex = 1; subIndex < size; subIndex++) {
                    temp.setNext(new Node(Integer.parseInt(br.readLine()), null));
                    temp = temp.getNext();
                }
            }

            Node root = mergeKLL(arr, k);

            System.out.print(root.getData() + " ");
            Node next = root.getNext();

            while (next != null) {
                System.out.print(next.getData() + " ");
                next = next.getNext();
            }
        }
    }
}
