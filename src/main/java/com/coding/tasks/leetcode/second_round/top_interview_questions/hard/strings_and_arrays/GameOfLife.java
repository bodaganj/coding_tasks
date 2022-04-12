package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.Arrays;

public class GameOfLife {

   private static int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

   public static void main(String[] args) {
      int[][] arr = {
         {0, 1, 0},
         {0, 0, 1},
         {1, 1, 1},
         {0, 0, 0},
      };

      System.out.println(Arrays.deepToString(arr));
      gameOfLife(arr);
      System.out.println("=====");
      System.out.println(Arrays.deepToString(arr));
   }

   // 2 = should be dead, but was live
   // 3 = should be live, but was dead
   private static void gameOfLife(int[][] board) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            int liveNeighbors = getLiveNeighbors(board, i, j);
            if (liveNeighbors < 2 || liveNeighbors > 3) {
               if (board[i][j] == 1) {
                  board[i][j] = 2;
               }
            } else {
               if (board[i][j] == 0 && liveNeighbors == 3) {
                  board[i][j] = 3;
               }
            }
         }
      }

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == 2) {
               board[i][j] = 0;
            }
            if (board[i][j] == 3) {
               board[i][j] = 1;
            }
         }
      }
   }

   private static int getLiveNeighbors(int[][] board, int i, int j) {
      int counter = 0;
      for (int[] direction : directions) {
         counter += getLiveNeighborsRec(board, i + direction[0], j + direction[1]);
      }

      return counter;
   }

   private static int getLiveNeighborsRec(int[][] board, int i, int j) {
      if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
         if (board[i][j] == 1 || board[i][j] == 2) {
            return 1;
         }
      }
      return 0;
   }
}
