package com.insignia.LinkedList;

import java.io.*;
import java.util.LinkedList;

public class LinkedListToQueueAdapter {

    LinkedList<Integer> list;

    public LinkedListToQueueAdapter() {
      list = new LinkedList<>();
    }


    int size() {
      return list.size();
    }

    void push(int val) {
      list.add(val);
    }

    int pop() {
        
     if(list.size()==0){
        System.out.println("Stack underflow");
        return -1;
    }
     
     return list.removeLast();
    }

    int top() {
        if(list.size()==0){
            System.out.println("Stack underflow");
            return -1;
        }
      return list.getLast();
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedListToQueueAdapter st = new LinkedListToQueueAdapter();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}