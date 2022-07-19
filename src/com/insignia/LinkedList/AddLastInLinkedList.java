package com.insignia.LinkedList;

import java.io.*;

public class AddLastInLinkedList {

  public static void testList(LinkedList list) {
    for (Node temp = list.head; temp != null; temp = temp.getNext()) {
      System.out.println(temp.getData());
    }
    System.out.println(list.size);

    if (list.size > 0) {
      System.out.println(list.tail.getData());
    } 
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addLast")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } 
      str = br.readLine();
    }

    testList(list);
  }
}