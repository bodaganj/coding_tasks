package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

   private static List<List<String>> ans;

   public static void main(String[] args) {
      System.out.println(solveNQueens(4));
   }

   private static List<List<String>> solveNQueens(int n) {
      ans = new ArrayList<>();
      rec(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n, new ArrayList<>());
      return ans;
   }

   private static void rec(int row, Set<Integer> diag, Set<Integer> antiDiag, Set<Integer> cols, int n, List<String> current) {
      if (current.size() == n) {
         List<String> newList = new ArrayList<>(current);
         ans.add(newList);
         return;
      }

      if (row < n) {
         for (int i = 0; i < n; i++) {
            if (!diag.contains(row - i) && !antiDiag.contains(row + i) && !cols.contains(i)) {
               diag.add(row - i);
               antiDiag.add(row + i);
               cols.add(i);
               current.add(createString(i, n));

               rec(row + 1, diag, antiDiag, cols, n, current);

               diag.remove(row - i);
               antiDiag.remove(row + i);
               cols.remove(i);
               current.remove(current.size() - 1);
            }
         }
      }
   }

   private static String createString(int column, int n) {
      StringBuilder template = new StringBuilder();
      while (n-- > 0) {
         template.append('.');
      }
      template.setCharAt(column, 'Q');
      return template.toString();
   }
}
