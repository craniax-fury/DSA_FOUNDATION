// package com.insignia.dynamicProgrammingRecursive.LeetCode;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class LongestPalindromicSubstringLength {

//     private static int lps(String ros,String ssf,int length) {
//         if(ros.length()==0){
//             return length;
//         }

//         int lps = length;

//         if(isPalindrome(ssf+ros.substring(0,1))){
//             lps=ssf.length()+1;
//         }

//         int pick = lps(ros.substring(1),ssf+ros.substring(0,1),lps);
//         int skip = lps(ros.substring(1),ssf,lps);

//         return Math.max(lps,Math.max(pick,skip));
//     }

//     private static int lpsMemo(String ros,String ssf,int length,int[] lpl) {
//         if(ros.length()==0){
//             return length;
//         }

//         if(lpl[])

//         int lps = length;

//         if(isPalindrome(ssf+ros.substring(0,1))){
//             lps=ssf.length()+1;
//         }

//         int pick = lps(ros.substring(1),ssf+ros.substring(0,1),lps);
//         int skip = lps(ros.substring(1),ssf,lps);

//         return Math.max(lps,Math.max(pick,skip));
//     }

//     private static boolean isPalindrome(String string) {
//         int start = 0;
//         int end = string.length()-1;

//         while(start<end){
//             if(!(string.charAt(start)==string.charAt(end))){
//                 return false;
//             }
//             start++;
//             end--;
//         }
//         return true;
//     }

//     public static void main(String[] args) throws IOException {

//         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//             String n = reader.readLine();

//             System.out.println(lps(n,"",0));

//         }
//     }

//     private static void display(int[] soln) {
//         for (int i = 0; i < soln.length; i++) {
//             System.out.print(soln[i] + " ");
//         }
//     }
// }
