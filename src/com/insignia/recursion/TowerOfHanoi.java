package com.insignia.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TowerOfHanoi {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // int numberOfTower = Integer.parseInt(reader.readLine());
            // int tower1 = Integer.parseInt(reader.readLine());
            // int tower2 = Integer.parseInt(reader.readLine());
            // int tower3 = Integer.parseInt(reader.readLine());

            toh(3,10,11,12);
        }
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if (n == 0) {
            return;
        }

        toh(n-1, t1id,t3id,t2id);
        System.out.println(n+"["+t1id+" -> "+t2id+"]");
        toh(n-1, t3id,t2id, t1id);

    }
}
