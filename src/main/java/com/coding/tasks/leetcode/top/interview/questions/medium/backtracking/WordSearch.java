package com.coding.tasks.leetcode.top.interview.questions.medium.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

   private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(exist(new char[][]{
         {'A', 'B', 'C', 'E'},
         {'S', 'F', 'C', 'S'},
         {'A', 'D', 'E', 'E'}
      }, "ABCCED"));

      System.out.println(exist(new char[][]{
         {'A', 'B', 'C', 'E'},
         {'S', 'F', 'C', 'S'},
         {'A', 'D', 'E', 'E'}
      }, "ABCB"));

      System.out.println(exist(new char[][]{
         {'C', 'A', 'A'},
         {'A', 'A', 'A'},
         {'B', 'C', 'D'}
      }, "AAB"));
   }

   private static boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == word.charAt(0)) {
               Tuple tuple = new Tuple(i, j);
               boolean isFound = dfs(board, tuple, word.substring(1), Set.of(tuple));
               if (isFound) {
                  return true;
               }
            }
         }
      }
      return false;
   }

   private static boolean dfs(char[][] board, Tuple current, String wordToBeFound, Set<Tuple> visited) {
      if (wordToBeFound.isBlank()) {
         return true;
      }
      for (int[] ints : dir) {
         int x = current.x + ints[0];
         int y = current.y + ints[1];
         Tuple newTuple = new Tuple(x, y);
         if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited.contains(newTuple)
            && board[x][y] == wordToBeFound.charAt(0)) {
            Set<Tuple> newVisited = new HashSet<>(visited);
            newVisited.add(newTuple);
            if (dfs(board, newTuple, wordToBeFound.substring(1), newVisited)) {
               return true;
            }
         }
      }
      return false;
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
