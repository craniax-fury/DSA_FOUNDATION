package com.insignia.linkedListLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseUsingAddFirst {

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

    public void printList(Node node) {
      while (node != null) {
        System.out.print(node.data + "-> ");
        node = node.next;
      }
      System.out.println("null");
    }

    private Node reverse(Node head) {
      if(head==null || head.next==null){
        return head;
      }

      Node curr = head;
      Node fwd = curr.next;

      while(curr!=null){
        curr.next=null;
        addFirst(curr);
        curr=fwd;

        if(fwd!=null){
          fwd=fwd.next;
        }
      }

      return th;
    }

    private static Node th = null;

    private void addFirst(Node curr) {
      if(curr==null){
        return;
      }

      if(th!=null){
        Node temp = th;
        th = curr;
        curr.next = temp;
      }else{
        th=curr;
      }
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
        }
        if (str.startsWith("2addLast")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          list2.addLast(val);
        } else if (str.startsWith("reverse")) {
          list.printList(list.reverse(list.head));

        }
        str = br.readLine();

      }

    }

  }
}