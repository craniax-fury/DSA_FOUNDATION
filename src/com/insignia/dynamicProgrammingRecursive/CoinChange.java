package com.insignia.dynamicProgrammingRecursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange {

  public int change(int amount, int[] coins) {
    return helper(coins, amount, coins.length - 1);
  }

  private int helper(int[] coins, int amount, int i) {
    if (amount == 0)
      return 1;

    if (i == 0) {
      if (amount % coins[0] == 0)
        return 1;
      else
        return 0;
    }

    int pick = 0;
    if (amount >= coins[i]) {
      pick = helper(coins, amount - coins[i], i);
    }

    int notPick = helper(coins, amount, i - 1);

    return pick + notPick;
  }
  // MEMOIZATION

  public int changeM(int amount, int[] coins) {

    int[][] dp = new int[coins.length][amount + 1];
    for (int i = 0; i < coins.length; i++) {
      Arrays.fill(dp[i], -1);
    }

    return helperM(coins, amount, coins.length - 1, dp);
  }

  private int helperM(int[] coins, int amount, int i, int[][] dp) {
    if (amount == 0)
      return 1;

    if (i == 0) {
      if (amount % coins[0] == 0)
        return 1;
      else
        return 0;
    }

    if (dp[i][amount] != -1)
      return dp[i][amount];

    int pick = 0;
    if (amount >= coins[i]) {
      pick = helperM(coins, amount - coins[i], i, dp);
    }

    int notPick = helperM(coins, amount, i - 1, dp);

    dp[i][amount] = pick + notPick;

    return dp[i][amount];
  }

  // TABULATION

  public int changeT(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for (int i = 0; i < coins.length; i++) {
      dp[i][0] = 1;
    }

    for (int j = 0; j <= amount; j++) {
      if (j % coins[0] == 0)
        dp[0][j] = 1;
      else
        dp[0][j] = 0;
    }

    for (int i = 1; i < n; i++) {
      for (int amt = 1; amt <= amount; amt++) {
        int notTake = dp[i - 1][amt];

        int take = 0;
        if (amt >= coins[i]) {
          take = dp[i][amt - coins[i]];
        }

        dp[i][amt] = (take + notTake);
      }
    }

    return dp[n - 1][amount];

  }

  // private static int coinChangePerms(int[] den,int target,int ssf,String psf){
  // int ans=0;

  // if(ssf==target){
  // return 1;
  // }

  // if(ssf>target){
  // return 0;
  // }

  // for(int i=0;i<den.length;i++){
  // if(ssf+den[i]<=target){
  // ans+= coinChangePerms(den, target, ssf+den[i],psf+den[i]);
  // }
  // }

  // return ans;
  // }

  private static int coinChangePermsMemo(int[] den, int target, int ssf, String psf, int[] dp) {

    if (ssf == target) {
      dp[ssf] = 1;
      return 1;
    }

    if (dp[ssf] != 0) {
      return dp[ssf];
    }

    for (int i = 0; i < den.length; i++) {
      if (ssf + den[i] <= target) {
        dp[ssf] += coinChangePermsMemo(den, target, ssf + den[i], psf + den[i], dp);
      }
    }

    return dp[ssf];
  }

  private static int coinChangePermsTabu(int[] den, int target, int ssf, String psf, int[] dp) {

    for (int i = 0; i <= target; i++) {

      for (int j = 0; j < den.length; j++) {
        if (i - den[j] >= 0 && dp[i - den[j]] != 0) {
          dp[i] += dp[i - den[j]];
        }
      }
    }
    return dp[target];

  }

  public static void main(String[] args) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(reader.readLine());
      int[] den = new int[n];

      for (int i = 0; i < n; i++) {
        den[i] = Integer.parseInt(reader.readLine());
      }

      int target = Integer.parseInt(reader.readLine());
      int[] dp = new int[target + 1];
      dp[0]=1;
      System.out.println(coinChangePermsTabu(den, target, 0, "", dp));
      // display1d(dp);
    }
  }

  private static void display1d(int[] soln) {
    for (int ele : soln) {
      if (ele == -1) {
        System.out.print(ele + " ");
      } else {
        System.out.print(" " + ele + " ");
      }

    }
  }

  private static void display2d(int[][] soln) {
    for (int[] eleArr : soln) {
      display1d(eleArr);
      System.out.println();
    }
  }

}
