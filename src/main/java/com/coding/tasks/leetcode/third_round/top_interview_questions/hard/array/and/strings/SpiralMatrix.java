package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {

   public static void main(String[] args) {
      System.out.println(spiralOrder(new int[][]{
         {1, 2, 3},
         {4, 5, 6},
         {7, 8, 9}
      }));

      System.out.println(spiralOrder(new int[][]{
         {1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 10, 11, 12},
         {13, 14, 15, 16}
      }));
   }

   public static List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> ans = new ArrayList<>();
      dfs(0, 0, 0, 1, matrix, new HashSet<>(), ans);
      return ans;
   }

   private static void dfs(int x, int xDif, int y, int yDif, int[][] matrix, Set<Pair> seen, List<Integer> ans) {
      if (!seen.contains(new Pair(x, y)) && x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
         ans.add(matrix[x][y]);
         seen.add(new Pair(x, y));
         dfs(x + xDif, xDif, y + yDif, yDif, matrix, seen, ans);
         dfs(x, 0, y + 1, 1, matrix, seen, ans);
         dfs(x + 1, 1, y, 0, matrix, seen, ans);
         dfs(x, 0, y - 1, -1, matrix, seen, ans);
         dfs(x - 1, -1, y, 0, matrix, seen, ans);
      }
   }

   private record Pair(int x, int y) {

   }
}
