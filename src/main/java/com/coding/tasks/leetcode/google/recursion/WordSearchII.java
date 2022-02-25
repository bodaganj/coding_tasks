package com.coding.tasks.leetcode.google.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {

   }

   private static List<String> findWords(char[][] board, String[] words) {
      Set<String> ans = new HashSet<>();

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            for (String word : words) {
               if (!ans.contains(word) && word.startsWith("" + board[i][j])) {
                  Tuple tuple = new Tuple(i, j);
                  Set<Tuple> visited = new HashSet<>();
                  visited.add(tuple);

                  dfs(tuple, 1, word, visited, ans, board);
               }
            }
         }
      }

      return new ArrayList<>(ans);
   }

   private static void dfs(Tuple current, int nextIndex, String word, Set<Tuple> visited, Set<String> ans, char[][] board) {
      if (nextIndex == word.length() || ans.contains(word)) {
         ans.add(word);
         return;
      }

      for (int[] dir : dirs) {
         int x = current.x + dir[0];
         int y = current.y + dir[1];
         Tuple newTuple = new Tuple(x, y);

         if (x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
            !visited.contains(newTuple) && board[x][y] == word.charAt(nextIndex)) {
            Set<Tuple> newSet = new HashSet<>(visited);
            newSet.add(newTuple);

            dfs(newTuple, nextIndex + 1, word, newSet, ans, board);
         }
      }
   }

   static class Tuple {

      public int x;
      public int y;

      public Tuple(int x, int y) {
         this.x = x;
         this.y = y;
      }

      @Override
      public boolean equals(Object o) {
         Tuple t = (Tuple) o;
         return t != null && t.x == this.x && t.y == this.y;
      }

      @Override
      public int hashCode() {
         return x * 31 + y;
      }
   }
}
