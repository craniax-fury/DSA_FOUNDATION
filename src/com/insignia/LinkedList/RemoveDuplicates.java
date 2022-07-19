package com.insignia.LinkedList;

import java.io.*;

public class RemoveDuplicates {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size() {
      return size;
    }

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public static LinkedList mergeSort(Node head, Node tail) {
      if (head == tail) {
        LinkedList list = new LinkedList();
        list.addLast(head.data);
        return list;

      } else {
        Node mid = midNode(head, tail);
        LinkedList leftList = mergeSort(head, mid);
        LinkedList rightList = mergeSort(mid.next, tail);
        return merge(leftList, rightList);
      }
    }

    public static Node midNode(Node head, Node tail) {
      Node fast = head;
      Node slow = head;

      while (fast != tail && fast.next != tail) {
        fast = fast.next.next;
        slow = slow.next;
      }

      return slow;
    }

    private static LinkedList merge(LinkedList leftList, LinkedList rightList) {
      Node leftNode = leftList.head;
      Node rightNode = rightList.head;
      LinkedList sortedList = new LinkedList();

      while (leftNode != null && rightNode != null) {
        if (leftNode.data <= rightNode.data) {
          sortedList.addLast(leftNode.data);
          leftNode = leftNode.next;
        } else {
          sortedList.addLast(rightNode.data);
          rightNode = rightNode.next;
        }
      }

      while (leftNode != null) {
        sortedList.addLast(leftNode.data);
        leftNode = leftNode.next;
      }

      while (rightNode != null) {
        sortedList.addLast(rightNode.data);
        rightNode = rightNode.next;
      }
      return sortedList;
    }

    public void removeDuplicates() {

      if (head.next == null) {
        return;
      }

      if (head.next.next == null) {
        if (head.data == head.next.data) {
          head.next = null;
          return;
        }
      }

      Node temp = head.next.next;
      Node prev = head;
      Node curr = head.next;

      while (temp != null) {
        if (prev.data == curr.data) {
          prev.next = temp;
          curr = curr.next;
          temp = temp.next;
        } else {
          temp = temp.next;
          prev = prev.next;
          curr = curr.next;
        }
      }

      if (prev.data == curr.data) {
        prev.next = null;
      }
    }

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n1 = Integer.parseInt(br.readLine());
      LinkedList l1 = new LinkedList();
      String[] values1 = br.readLine().split(" ");
      for (int i = 0; i < n1; i++) {
        int d = Integer.parseInt(values1[i]);
        l1.addLast(d);
      }

      l1.display();
      l1.removeDuplicates();
      l1.display();
    }
  }
}