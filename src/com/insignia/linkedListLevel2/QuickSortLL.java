package com.insignia.linkedListLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuickSortLL {

  public static class Node {
    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public Node() {
    }

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

    private Node getTail(Node head) {
      if (head == null || head.next == null) {
        return head;
      }

      Node curr = head;

      while (curr.next != null) {
        curr = curr.next;
      }

      return curr;

    }

    public void printList(Node node) {
      while (node != null) {
        System.out.print(node.data + "-> ");
        node = node.next;
      }
      System.out.println("null");
    }

    private void createDummyList() {
      Node dummy = new Node(-1);
      Node prev = dummy;

      Node node1 = new Node(1);
      prev.next = node1;
      prev = node1;
      head = node1;

      for (int i = 2; i <= 4; i++) {
        Node node = new Node(i);
        prev.next = node;
        prev = node;
      }

      Node node5 = new Node(5);
      prev.next = node5;
      prev = node5;

      for (int i = 6; i < 10; i++) {
        Node node = new Node(i);
        prev.next = node;
        prev = node;
      }

      Node nodeL = new Node(5);
      prev.next = nodeL;
      prev = nodeL;
    }

    private Node[] segregateNodesOverLast(Node head) {
      if (head == null || head.next == null) {
        return new Node[] { head };
      }

      Node sh = new Node(-1);
      Node lh = new Node(-1);
      Node eqh = new Node(-1);

      Node tsh = sh;
      Node tlh = lh;
      Node teqh = eqh;

      Node curr = head;
      Node last = getTail(head);

      while (curr != null) {
        if (curr.data < last.data) {
          tsh.next = curr;
          tsh = curr;
        } else if (curr.data == last.data) {
          teqh.next = curr;
          teqh = curr;
        } else {
          tlh.next = curr;
          tlh = curr;
        }
        curr = curr.next;

      }

      teqh.next = null;
      tsh.next = null;
      tlh.next = null;

      return new Node[] { sh.next, eqh.next, lh.next };

    }

    private Node[] quickSortLL(Node head) {
      if (head == null || head.next == null) {
        return new Node[] { head };
      }

      Node[] segregate = segregateNodesOverLast(head);

      Node[] left = null;
      Node[] equal = null;
      Node[] right = null;

      if (segregate[0] != null)
        left = quickSortLL(segregate[0]);
      if (segregate[1] != null)
        equal = quickSortLL(segregate[1]);
      if (segregate[2] != null)
        right = quickSortLL(segregate[2]);

      return new Node[] { merge(left, equal, right) };
    }

    private Node merge(Node[] left, Node[] equal, Node[] right) {
      Node lh = new Node(-1);
      Node eqh = new Node(-1);
      Node rh = new Node(-1);

      if (left != null && left.length > 0) {
        lh.next = left[0];
      }

      if (equal != null && equal.length > 0) {
        eqh.next = equal[0];
      }

      if (right != null && right.length > 0) {
        rh.next = right[0];
      }

      Node lTail = getTail(lh.next);
      Node eqTail = getTail(eqh.next);
      Node rtTail = getTail(rh.next);

      if (rtTail != null) {
        rtTail.next = null;
      }
      if (eqTail != null) {
        eqTail.next = rh.next;
      }

      if (lTail != null) {
        if (eqh.next != null) {
          lTail.next = eqh.next;
        } else {
          lTail.next = rh.next;
        }
      } else {
        if (eqh.next != null) {
          lh.next = eqh.next;
        } else {
          lh.next = rh.next;
        }

      }

      return lh.next;

    }

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      LinkedList list = new LinkedList();
      LinkedList list2 = new LinkedList();

      String str = br.readLine();
      while (str.equals("quit") == false) {
        if (str.startsWith("addLast")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          list.addLast(val);
        } else if (str.startsWith("2addLast")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          list2.addLast(val);
        } else if (str.startsWith("dummyList")) {
          list.createDummyList();
        } else if (str.startsWith("QuickSortLL")) {
          list.printList(list.quickSortLL(list.head)[0]);
        }

        str = br.readLine();

      }

    }

  }
}
