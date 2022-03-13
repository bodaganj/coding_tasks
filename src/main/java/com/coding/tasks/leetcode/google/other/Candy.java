package com.coding.tasks.leetcode.google.other;

import java.util.Arrays;

public class Candy {

   public static void main(String[] args) {
      System.out.println(candy(new int[]{29, 51, 87, 87, 72, 12}));
      System.out.println(candy(new int[]{1, 0, 2}));
      System.out.println(candy(new int[]{1, 2, 2}));
   }

   private static int candy(int[] ratings) {
      int[] candies = new int[ratings.length];

      for (int i = 1; i < ratings.length; i++) {
         if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
         }
      }

      for (int i = ratings.length - 2; i >= 0; i--) {
         if (ratings[i] > ratings[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
         }
      }

      return Arrays.stream(candies).sum() + ratings.length;
   }
}
