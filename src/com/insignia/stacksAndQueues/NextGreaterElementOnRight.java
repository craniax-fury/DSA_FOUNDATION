package com.insignia.stacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Below logic works because we have started pushing the numbers from the right,
 * and for any number we want to push, we are removing all the numbers which are smaller to my current number
 * then if there is any number which is left then that is the answer for the current number,
 * then any further numbers that we will push from the left, for them either the current number 
 * or the number that was greater than the current number can be the answer.
 */

 /**
  * in this program there are two operation one is push another is pop
  * so push is being done every time so , n
  * elements which are there in the stack can only be popped
  * so pop also can execute for n times 
  * The complexity in worst case of this program is n+n=2n
  */
public class NextGreaterElementOnRight {

    public static void main(String[] args)throws Exception {

        Stack<Integer> stack = new Stack<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int input_length = Integer.parseInt(reader.readLine());
            int[] inputArray = new int[input_length];
            int[] outputArray = new int[input_length];

            for(int index=0;index<input_length;index++){
                inputArray[index] = Integer.parseInt(reader.readLine());
            }

            for(int index=0;index<input_length;index++){
                if(stack.size()==0){
                    stack.push(index);
                
                }else if(inputArray[stack.peek()]>inputArray[index]){
                    stack.push(index);
                
                }else if(inputArray[stack.peek()]<inputArray[index]){
                    
                    while(stack.size()>0 && inputArray[stack.peek()]<=inputArray[index]){
                        outputArray[stack.pop()]=inputArray[index];
                    }

                    stack.push(index);
                }
            }

            while(stack.size()!=0){
                outputArray[stack.pop()]=-1;
            }

            for(int val:outputArray){
                System.out.println(val);
            }
        }
    }
} 