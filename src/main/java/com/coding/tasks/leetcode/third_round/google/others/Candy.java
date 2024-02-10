package com.coding.tasks.leetcode.third_round.google.others;

import java.util.Arrays;

public class Candy {

   public static void main(String[] args) {
      System.out.println(candy(new int[]{1, 0, 2})); // 5
      System.out.println(candy(new int[]{1, 2, 2})); // 4
      System.out.println(candy(new int[]{1, 3, 4, 5, 2})); // 11
   }

   public static int candy(int[] ratings) {
      int[] ans = new int[ratings.length];
      Arrays.fill(ans, 1);

      for (int i = 1; i < ans.length; i++) {
         if (ratings[i] > ratings[i - 1]) {
            ans[i] = ans[i - 1] + 1;
         }
      }
      for (int i = ans.length - 2; i >= 0; i--) {
         if (ratings[i] > ratings[i + 1] && ans[i] <= ans[i + 1]) {
            ans[i] = ans[i + 1] + 1;
         }
      }

      return Arrays.stream(ans).sum();
   }
}
