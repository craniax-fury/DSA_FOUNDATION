package com.insignia.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

  
public class Test {

    private static <T> void printMe(List<T> list){
        System.out.println(list);
    }
    
    private static void print2(List<?> list){
        System.out.println(list);
    }

    public static void main(String[] args) throws IOException{
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           
            printMe(Arrays.asList(1,2,3));
            printMe(Arrays.asList("1","2","3"));

            print2(Arrays.asList(1,2,3));
            print2(Arrays.asList("1","2","3"));


            
            double price = 1000;
            double discount = 0.9;
            double discountAmount = price * discount;

            System.out.println("(price - discountAmount) , correct in double: " + (price - discountAmount));
            System.out.println("price * (1 - discount) , faulty: " + price * (1 - discount));

            BigDecimal price1 = new BigDecimal("1000");
            BigDecimal discStringInConstructor = new BigDecimal("0.9");
            BigDecimal discDoubleInConstructor = new BigDecimal(0.9);
            BigDecimal discAmountDouble = price1.multiply(discDoubleInConstructor);
            BigDecimal discAmountString = price1.multiply(discStringInConstructor);

            System.out.println("price1.subtract(discAmount), faulty in bigDecimal " + price1.subtract(discAmountDouble));
            System.out.println("price1.subtract(discAmount), correct in bigDecimal " + price1.subtract(discAmountString));
            System.out.println("price1.multiply(BigDecimal.ONE.subtract(disc)) , faulty in bigDecimal:" + price1.multiply(BigDecimal.ONE.subtract(discDoubleInConstructor)));
            System.out.println("price1.multiply(BigDecimal.ONE.subtract(disc)) , correct in bigDecimal:" + price1.multiply(BigDecimal.ONE.subtract(discStringInConstructor)));
        }
        
    }
}