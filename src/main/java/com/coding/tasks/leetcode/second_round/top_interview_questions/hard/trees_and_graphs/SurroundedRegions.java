package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

import java.util.Arrays;

public class SurroundedRegions {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      char[][] arr1 = new char[][]{
         {'X', 'X', 'X', 'X'},
         {'X', 'O', 'O', 'X'},
         {'X', 'X', 'O', 'X'},
         {'X', 'O', 'X', 'X'}
      };

      char[][] arr2 = new char[][]{
         {'O', 'X', 'X', 'O', 'X'},
         {'X', 'O', 'O', 'X', 'O'},
         {'X', 'O', 'X', 'O', 'X'},
         {'O', 'X', 'O', 'O', 'O'},
         {'X', 'X', 'O', 'X', 'O'}
      };

      solve(arr1);
//      solve(arr2);

      System.out.println(Arrays.deepToString(arr1));
//      System.out.println(Arrays.deepToString(arr2));
   }

   private static void solve(char[][] board) {
      for (int i = 0; i < board[0].length; i++) {
         capture(board, 0, i);
         capture(board, board.length - 1, i);
      }
      for (int i = 0; i < board.length; i++) {
         capture(board, i, 0);
         capture(board, i, board[0].length - 1);
      }

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == '#') {
               board[i][j] = 'O';
            } else {
               board[i][j] = 'X';
            }
         }
      }
   }

   private static void capture(char[][] board, int i, int j) {
      if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {
         board[i][j] = '#';
         for (int[] dir : dirs) {
            capture(board, i + dir[0], j + dir[1]);
         }
      }
   }
}
