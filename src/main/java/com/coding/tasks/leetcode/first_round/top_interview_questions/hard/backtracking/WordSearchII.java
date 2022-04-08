package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

   private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oath", "pea", "eat", "rain"}));
   }

   private static List<String> findWords(char[][] board, String[] words) {
      Set<String> ans = new HashSet<>();

      for (String word : words) {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (board[i][j] == word.charAt(0)) {
                  dfs(word, 0, new Tuple(i, j), board, new HashSet<>(), ans);
               }
               if (ans.contains(word)) {
                  break;
               }
            }
            if (ans.contains(word)) {
               break;
            }
         }
      }

      return new ArrayList<>(ans);
   }

   private static void dfs(String word, int index, Tuple tuple, char[][] board, Set<Tuple> visited, Set<String> ans) {
      if (index == word.length() - 1) {
         ans.add(word);
         return;
      }

      Set<Tuple> newVisited = new HashSet<>(visited);
      newVisited.add(tuple);

      for (int[] ints : dir) {
         int x = tuple.x + ints[0];
         int y = tuple.y + ints[1];
         Tuple newTuple = new Tuple(x, y);

         if (x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
            !newVisited.contains(newTuple) && board[x][y] == word.charAt(index + 1)) {
            dfs(word, index + 1, newTuple, board, newVisited, ans);
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
