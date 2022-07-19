package com.insignia.stacksAndQueues;

import java.util.Scanner;
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

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int input_length = sc.nextInt();
            int[] input = new int[input_length];

            for (int index = 0; index < input_length; index++) {
                input[index] = sc.nextInt();
            }

            Stack<Integer> stack = new Stack<>();
            int[] output = new int[input_length];

            output[input_length-1]=-1;
            stack.push(input[input_length-1]);

            for (int index = input_length-2; index >= 0; index--) {

                while(stack.size()>0 && !(stack.peek()>input[index])){
                    stack.pop();
                }

                if(stack.size()==0){
                    output[index]=-1;
                    stack.push(input[index]);
                }else{
                    output[index]=stack.peek();
                    stack.push(input[index]);
                }
            }

            for(int val:output){
                System.out.println(val);
            }
        }
    }
} 