package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberForPattern {

  
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            char[] inputChars = input.toCharArray();
            
            Stack<Integer> dataStack = new Stack<>(); 

            int num = 1;
            for(int index=0;index<input.length();index++){
                
                if(inputChars[index]=='i'){
                    dataStack.push(num);
                    num++;
                    popAndEmptyStack(dataStack);
                }else if(inputChars[index]=='d'){
                    dataStack.push(num);
                    num++;
                }
            }

            dataStack.push(num);
            popAndEmptyStack(dataStack);
        }
    }

    private static void popAndEmptyStack(Stack<Integer> dataStack) {
        while(dataStack.size()>0){
            System.out.print(dataStack.pop());
        }
    }

}
