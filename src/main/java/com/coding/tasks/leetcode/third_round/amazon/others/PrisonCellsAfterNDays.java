package com.coding.tasks.leetcode.third_round.amazon.others;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

   public static void main(String[] args) {
//      System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
      System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 1, 0, 1, 1, 0, 0, 1}, 300663720)));
   }

   public static int[] prisonAfterNDays(int[] cells, int n) {
      int[] ans = new int[cells.length];
      int count = n % 14 == 0 ? 14 : n % 14;
      for (int i = 0; i < count; i++) {
         for (int j = 1; j < ans.length - 1; j++) {
            if (cells[j - 1] == cells[j + 1]) {
               ans[j] = 1;
            } else {
               ans[j] = 0;
            }
         }
         System.out.println(Arrays.toString(ans));
         cells = Arrays.copyOf(ans, ans.length);
      }
      return cells;
   }
}
