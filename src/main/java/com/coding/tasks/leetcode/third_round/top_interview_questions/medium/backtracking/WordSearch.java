package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch {

   private static List<int[]> indexes = List.of(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});

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
   }

   public static boolean exist(char[][] board, String word) {
      // check we have enough chars in matrix
      if (board.length * board[0].length < word.length()) {
         return false;
      }

      // check we have all needed chars in matrix
      Map<Character, Integer> mapping = new HashMap<>();
      for (char c : word.toCharArray()) {
         mapping.put(c, mapping.getOrDefault(c, 0) + 1);
      }
      for (char[] chars : board) {
         for (int col = 0; col < board[0].length; col++) {
            char current = chars[col];
            if (mapping.containsKey(current)) {
               if (mapping.get(current) == 1) {
                  mapping.remove(current);
               } else {
                  mapping.put(current, mapping.get(current) - 1);
               }
            }
         }
      }

      if (!mapping.isEmpty()) {
         return false;
      }

      // find the answer
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == word.charAt(0)) {
               if (rec(board, word, 0, i, j, new HashSet<>())) {
                  return true;
               }
            }
         }
      }
      return false;
   }

   private static boolean rec(char[][] board, String word, int wordIndex, int i, int j, Set<List<Integer>> seen) {
      if (wordIndex == word.length()) {
         return true;
      } else {
         if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !seen.contains(List.of(i, j)) && board[i][j] == word.charAt(
            wordIndex)) {
            Set<List<Integer>> tmp = new HashSet<>(seen);
            tmp.add(List.of(i, j));
            for (int[] index : indexes) {
               if (rec(board, word, wordIndex + 1, i + index[0], j + index[1], tmp)) {
                  return true;
               }
            }
         }
      }
      return false;
   }
}
