package com.insignia.linkedListLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FoldOfLinkedList {

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
    
        public void removeFirst() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            head = head.next;
            size--;
          }
        }
    
        public int getFirst() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return head.data;
          }
        }
    
        public int getLast() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return tail.data;
          }
        }
    
        public int getAt(int idx) {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
          } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
              temp = temp.next;
            }
            return temp.data;
          }
        }
    
        public void addFirst(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = head;
          head = temp;
    
          if (size == 0) {
            tail = temp;
          }
    
          size++;
        }
    
        public void addAt(int idx, int val) {
          if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            addFirst(val);
          } else if (idx == size) {
            addLast(val);
          } else {
            Node node = new Node();
            node.data = val;
    
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
            node.next = temp.next;
    
            temp.next = node;
            size++;
          }
        }
    
        public void removeLast() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
              temp = temp.next;
            }
    
            tail = temp;
            tail.next = null;
            size--;
          }
        }
    
        public void removeAt(int idx) {
          if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            removeFirst();
          } else if (idx == size - 1) {
            removeLast();
          } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
    
            temp.next = temp.next.next;
            size--;
          }
        }
    
        private Node getNodeAt(int idx) {
          Node temp = head;
          for (int i = 0; i < idx; i++) {
            temp = temp.next;
          }
          return temp;
        }
    
        public void reverseDI() {
          int li = 0;
          int ri = size - 1;
          while(li < ri){
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);
    
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
    
            li++;
            ri--;
          }
        }
     
        public void reversePI(){
            if(head==null || head.next==null){return;} // handle for 0 and 1 length cases
            Node prev=null;
            Node curr = head;

            while(curr!=null){
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr=temp;
            }
        }

        public void fold() { // O(n) space O(1)
          Node mid = mid(); // O(n)
          Node temp = mid.next;
          mid.next=null;

          Node reversedHead = reverse(temp); // O(n/2)
          
          Node startHead = head;
          Node endHead = reversedHead;
          Node next1 = null;
          Node next2 = null;

          while(endHead!=null){ //O(n/2)
            // taking extra nodes to avoid null pointed exceptions
            next1 = startHead.next;
            next2 = endHead.next;
             
            startHead.next = endHead;
            endHead.next = next1;
            
            startHead = next1;
            endHead = next2;
          }
        }

        public void printList(Node node){
          while(node!=null){
            System.out.print(node.data+"-> ");
            node=node.next;
          }
          System.out.print("null");
        }

        public Node mid(){

          if(head==null || head.next==null){
            return head;
          }

          Node slow = head;
          Node fast = head;

          while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
          }

          return slow;
        }

        public Node reverse(Node head){
          if(head==null || head.next==null){
            return head;
          }

          Node prev=null;
          Node curr = head;

          while(curr!=null){
            Node temp = curr.next;
            curr.next=prev;
            prev = curr;
            curr=temp;
          }

          return prev;
        }

        public void revertOrgReverse(Node head,Node mid){
          head = reverse(head);
          mid.next=head;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("addLast")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } else if (str.startsWith("fold")) {
            list.fold();
            list.printList(list.head);
          } 
          str = br.readLine();
        }
      }

}
