package com.insignia.linkedListPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LLToStack {
  
  LinkedList<Integer> list;

  public LLToStack() {
    list = new LinkedList<Integer>();
  }

    int size() {
      return list.size();
    }

    void push(int val) {
      list.addFirst(val);
    }

    int pop() {
      if(list.isEmpty()){
        System.out.println("Stack underflow");
        return -1;
      }

     return list.removeFirst();
    }

    int top() {
      if(list.isEmpty()){
        System.out.println("Stack underflow");
        return -1;
      }

      return list.getFirst();
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LLToStack st = new LLToStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}

