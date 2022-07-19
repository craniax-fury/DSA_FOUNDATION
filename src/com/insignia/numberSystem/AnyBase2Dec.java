package com.insignia.numberSystem;

import java.util.Scanner;

/**
 * for ex. for conversion of 1172 from base 8 to base 10,
 * find 2 then multiply it with 8^0, then 7 with 8^1 ......
 * finally add all these to get the resulting number in base 10
 */
public class AnyBase2Dec {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            int base = sc.nextInt();

            AnyBase2Dec anyBase2Dec = new AnyBase2Dec();
            System.out.println(anyBase2Dec.findNumberInDec(num, base));
        }
    }

    public int findNumberInDec(int num, int toBase) {
        int result = 0;
        int place =0;
        while (num > 0) {
            result+= (num % 10) * (int) Math.pow(toBase,place++);
            num = num / 10;
        }
        return result;
    }
}
