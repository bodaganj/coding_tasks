package com.coding.tasks.leetcode.second_round.amazon.others;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 40)));
      prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 40);
   }

   private static int[] prisonAfterNDays(int[] cells, int n) {
      while (n > 14) {
         n -= 14;
      }

      int[] dp = new int[cells.length];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < cells.length; j++) {
            if (j == 0 || j == cells.length - 1) {
               dp[j] = 0;
            } else {
               if (cells[j - 1] == cells[j + 1]) {
                  dp[j] = 1;
               } else {
                  dp[j] = 0;
               }
            }
         }

         System.arraycopy(dp, 0, cells, 0, dp.length);
         System.out.println(Arrays.toString(cells));
      }
      return cells;
   }
}
