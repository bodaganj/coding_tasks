package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
      char firstChar = word.charAt(0);
      List<List<Integer>> listOfFirstChar = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == firstChar) {
               listOfFirstChar.add(List.of(i, j));
            }
         }
      }

      for (List<Integer> coordinates : listOfFirstChar) {
         Set<List<Integer>> visited = new HashSet<>();
         visited.add(coordinates);
         if (dfs(coordinates, board, word, 1, visited)) {
            return true;
         }
      }
      return false;
   }

   private static boolean dfs(List<Integer> coordinates, char[][] board, String word, int index, Set<List<Integer>> visitedCoordinates) {
      if (index == word.length()) {
         return true;
      } else {
         Integer currX = coordinates.get(0);
         Integer currY = coordinates.get(1);

         for (int[] dir : dirs) {
            int i = currX + dir[0];
            int j = currY + dir[1];

            List<Integer> newCoordinates = List.of(i, j);
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length
               && board[i][j] == word.charAt(index) && !visitedCoordinates.contains(newCoordinates)) {
               visitedCoordinates.add(newCoordinates);

               if (dfs(newCoordinates, board, word, index + 1, visitedCoordinates)) {
                  return true;
               }

               visitedCoordinates.remove(newCoordinates);
            }
         }

         return false;
      }
   }
}
