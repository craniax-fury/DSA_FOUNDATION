package com.insignia.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomLinkedList {
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

    public void removeFirst() {

        if (size == 0) {
            System.out.println("List is empty");

        } else if (this.size == 1) {
            this.head = this.tail = null;
            this.size--;

        } else {
            this.head = this.head.next;
            this.size--;
        }
    }

    public int getFirst() {

        if (this.head == null) {
            System.out.println("List is empty");
            return -1;
        }

        return this.head.data;
    }

    public int getLast() {
        if (this.tail == null) {
            System.out.println("List is empty");
            return -1;
        }

        return this.tail.data;
    }

    public int getAt(int idx) {
        if (idx >= this.size) {
            System.out.println("Invalid arguments");
            return -1;
        }

        if (this.size == 0) {
            System.out.println("List is empty");
            return -1;
        }

        if (idx == 0) {
            return this.head.data;
        }

        if (idx == this.size - 1) {
            return this.tail.data;
        }

        Node tempNode = head;

        for (int i = 1; i <= idx; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.data;
    }

    public int size() {
        return this.size;
    }

    public void display() {
        Node node = this.head;
        if (this.size == 0) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println();

    }

    public void addFirst(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = this.head;
        this.head = newNode;

        if (this.tail == null) {
            this.tail = newNode;
        }

        this.size++;
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
            this.size--;
        } else {
            Node tempNode = new Node();
            tempNode = this.head;
            for (int i = 1; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
            this.size--;
        }
    }

    public void removeAt(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
        } else if (this.size == 0) {
            System.out.println("List is empty");

        } else if (this.size == 1 && idx == 0) {
            this.head = this.tail = null;
            this.size--;

        } else if (idx == 0) {
            Node tempNode = new Node();
            tempNode = head.next;
            head = tempNode;
            size--;

        } else if (idx == size - 1) {

            Node tempNode = new Node();
            tempNode = this.head;

            for (int index = 1; index < idx; index++) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
            tail = tempNode;
            size--;

        } else {
            Node tempNode = new Node();
            tempNode = this.head;

            for (int index = 1; index < idx; index++) {
                tempNode = tempNode.next;
            }

            Node nextNode = tempNode.next;
            tempNode.next = nextNode.next;
            size--;

        }
    }

    private Node getNodeAtI(int index){
        if(index<0){
            return null;
        }

        Node tempNode = head;
        for(int i=1;i<=index;i++){
            tempNode =  tempNode.next;
        }   
        
        return tempNode;
    }
    
    public void reverseDI() {
        int li=0;
        int ri=size-1;
        while(li<ri){
            Node leftNode = getNodeAtI(li);
            Node rightNode = getNodeAtI(ri);
            
            int temp = leftNode.data;
            leftNode.data= rightNode.data;
            rightNode.data=temp;
            
            li++;
            ri--;
        }
    }

    public void reversePI(){
        Node prev = null;
        Node curr=head;

        for(int index=0;index<size;index++){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        Node temNode=head;
        head=tail;
        tail=temNode;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CustomLinkedList list = new CustomLinkedList();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("addLast")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } else if (str.startsWith("size")) {
            System.out.println(list.size());
          } else if (str.startsWith("display")) {
            list.display();
          } else if (str.startsWith("removeFirst")) {
            list.removeFirst();
          } else if (str.startsWith("getFirst")) {
            int val = list.getFirst();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("getLast")) {
            int val = list.getLast();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("getAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            int val = list.getAt(idx);
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("addFirst")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addFirst(val);
          } else if (str.startsWith("addAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            int val = Integer.parseInt(str.split(" ")[2]);
            list.addAt(idx, val);
          } else if (str.startsWith("removeLast")) {
            list.removeLast();
          } else if (str.startsWith("removeAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            list.removeAt(idx);
          } else if(str.startsWith("reverseDI")){
            list.reverseDI();
          } else if(str.startsWith("reversePI")){
            list.reversePI();
          }
          str = br.readLine();
        }
      }
}