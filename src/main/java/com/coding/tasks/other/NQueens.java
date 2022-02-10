package com.coding.tasks.other;

import java.util.HashSet;
import java.util.Set;

public class NQueens {

   private static int length;

   public static void main(String[] args) {
      System.out.println(totalNQueens(4));
      System.out.println(totalNQueens(6));
      System.out.println(totalNQueens(8));
   }

   private static int totalNQueens(int n) {
      length = n;
      return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
   }

   private static int backtrack(int row, Set<Integer> diagonal, Set<Integer> antiDiagonal, Set<Integer> column) {
      if (row == length) {
         return 1;
      }

      int amount = 0;
      for (int i = 0; i < length; i++) {
         if (!column.contains(i) && !diagonal.contains(row - i) && !antiDiagonal.contains(row + i)) {
            column.add(i);
            diagonal.add(row - i);
            antiDiagonal.add(row + i);

            amount += backtrack(row + 1, diagonal, antiDiagonal, column);

            column.remove(i);
            diagonal.remove(row - i);
            antiDiagonal.remove(row + i);
         }
      }

      return amount;
   }
}
