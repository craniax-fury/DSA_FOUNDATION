package com.insignia.linkedListLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartingPointOfCycle {

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

    private void createDummyList() {
      Node dummy = new Node(-1);
      Node prev = dummy;
      
      Node node1 = new Node(1);
      prev.next=node1;
      prev = node1;
      head=node1;

      for(int i=2;i<10;i++){
        Node node = new Node(i);
        prev.next=node;
        prev=node;
      }
      
      prev.next=node1;
    }

    private boolean isCycleExist(Node head){

      if(head==null || head.next==null){
        return false;
      }

      if(head.next==head){
        return true;
      }

      Node curr = head;
      Node tempNode = new Node();

      while(curr!=null && (curr!=null && curr.next!=tempNode)){
        Node temp = curr.next;
        curr.next=tempNode;
        curr=temp;
      }

      if(curr==null){
        return false;
      }

      return true;

    }

    private boolean isCycleExistFloydCycle(Node head){

      if(head==null || head.next==null){
        return false;
      }

      if(head.next==head){
        return true;
      }

      Node dumNode = new Node(-1);
      dumNode.next=head;
      Node slow = dumNode;
      Node fast = head;

      while(fast.next!=null && fast.next.next!=null && slow!=fast){
        slow=slow.next;
        fast=fast.next.next;
      }

      if(fast.next==null || fast.next.next==null){
        return false;
      }

      return true;

    }

    private int startingPointOfCycle(Node head){

      if(head==null){
        return -1;
      }

      if(head.next==head){
        return head.data;
      }

      Node curr = head;
      Node tempNode = new Node();

      while(curr!=null && (curr!=null && curr.next!=tempNode)){
        Node temp = curr.next;
        curr.next = tempNode;

        curr = temp;
      }

      if(curr==null){
        return -1;
      }

      return curr.data;
    }

    private int startingPointOfFloydCycle(Node head){

      if(head==null){
        return -1;
      }

      if(head.next==head){
        return head.data;
      }

      Node dumNode = new Node(-1);
      dumNode.next=head;
      Node slow = dumNode;
      Node fast = head;

      while(fast.next!=null && fast.next.next!=null && slow!=fast){
       slow=slow.next;
       fast=fast.next.next;
      }

      if(fast.next==null || fast.next.next==null){
        return -1;
      }

      slow = head;

      while(slow!=fast){
        slow=slow.next;
        fast=fast.next;
      }

      return slow.data;
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
        }else if (str.startsWith("2addLast")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          list2.addLast(val);
        }else if (str.startsWith("dummyList")) {
          list.createDummyList();
        }else if(str.startsWith("checkCycle")){
          System.out.println(list.isCycleExist(list.head));
        }else if(str.startsWith("checkFloydCycle")){
          System.out.println(list.isCycleExistFloydCycle(list.head));
        }else if(str.startsWith("startPoint")){
          System.out.println(list.startingPointOfCycle(list.head));
        }else if(str.startsWith("floydStartPoint")){
          System.out.println(list.startingPointOfFloydCycle(list.head));
        }
        str = br.readLine();

      }

    }

   

  }
}