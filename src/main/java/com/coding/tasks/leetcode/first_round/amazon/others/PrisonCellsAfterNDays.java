package com.coding.tasks.leetcode.first_round.amazon.others;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
   }

   private static int[] prisonAfterNDays(int[] cells, int n) {
      int p = 0;
      for (int i = 0; i < cells.length; i++) {
         int tmp = cells[i];
         if (i == 0 || i == cells.length - 1) {
            cells[i] = 0;
         } else {
            if (p == cells[i + 1]) {
               cells[i] = 1;
            } else {
               cells[i] = 0;
            }
         }
         p = tmp;
      }

      for (int i = 1; i < n; i++) {
         int prev = 0;
         for (int j = 1; j < cells.length - 1; j++) {
            int tmp = cells[j];
            if (prev == cells[j + 1]) {
               cells[j] = 1;
            } else {
               cells[j] = 0;
            }
            prev = tmp;
         }
      }

      return cells;
   }
}
