package com.insignia.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PostfixEvalAndConversions {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String inputString = sc.nextLine();
            char[] input = inputString.toCharArray();

            Stack<Integer> operndStack = new Stack<>();
            Stack<String> infixOperndStack = new Stack<>();
            Stack<String> prefixOperndStack = new Stack<>();

            List<Character> operatorsList = new ArrayList<>();
            operatorsList.add('/');
            operatorsList.add('*');
            operatorsList.add('+');
            operatorsList.add('-');


            for(int index = 0;index<input.length;index++){
                if(input[index]==' '){
                    continue;
                }
                if(operndStack.size()>0 && operatorsList.contains(input[index])){
                    /**
                     * pop the operands from operand stack and apply the operator
                     */
                    int opernd1 = operndStack.pop();
                    int opernd2 = operndStack.pop();
                    
                    String infixOpernd1 = infixOperndStack.pop();
                    String infixOpernd2 = infixOperndStack.pop();

                    String prefixOpernd1 = prefixOperndStack.pop();
                    String prefixOpernd2 = prefixOperndStack.pop();
                    
                    operndStack.push(evaluateValue(opernd1,input[index],opernd2));
                    infixOperndStack.push(evaluateInfixExpression(infixOpernd1,input[index],infixOpernd2));
                    prefixOperndStack.push(evaluatePrefixExpression(prefixOpernd1,input[index],prefixOpernd2));

                }else{
                    operndStack.push(input[index]-'0');
                    infixOperndStack.push(String.valueOf(input[index]));
                    prefixOperndStack.push(String.valueOf(input[index]));
                }

            }

            System.out.println(operndStack.peek());
            System.out.println(infixOperndStack.peek());
            System.out.println(prefixOperndStack.peek());

        }
    }

    private static String evaluatePrefixExpression(String opernd1, char operator, String opernd2) {
        if(operator=='*'){
            return "*"+opernd2+opernd1;
        }else if(operator=='/'){
            return "/"+opernd2+opernd1;
        }else if(operator=='+'){
            return "+"+opernd2+opernd1;
        }else if(operator=='-'){
            return "-"+opernd2+opernd1;
        }
        return "";
    }

    private static String evaluateInfixExpression(String opernd1, char operator, String opernd2) {
        if(operator=='*'){
            return "("+opernd2+"*"+opernd1+")";
        }else if(operator=='/'){
            return "("+opernd2+"/"+opernd1+")";
        }else if(operator=='+'){
            return "("+opernd2+"+"+opernd1+")";
        }else if(operator=='-'){
            return "("+opernd2+"-"+opernd1+")";
        }
        return "";
    }

    private static Integer evaluateValue(int opernd1, char operator, int opernd2) {
        if(operator=='*'){
            return opernd2*opernd1;
        }else if(operator=='/'){
            return opernd2/opernd1;
        }else if(operator=='+'){
            return opernd2+opernd1;
        }else if(operator=='-'){
            return opernd2-opernd1;
        }
        return -99999;
    }
}
