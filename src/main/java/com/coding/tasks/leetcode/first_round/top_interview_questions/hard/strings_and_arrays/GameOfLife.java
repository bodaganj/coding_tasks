package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.strings_and_arrays;

import java.util.Arrays;

public class GameOfLife {

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

   private static void gameOfLife(int[][] board) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            int counter = getAmountOfOnesAround(board, i, j);

            if (board[i][j] == 1) {
               if (counter < 2 || counter > 3) {
                  board[i][j] = 2;
               }
            } else {
               if (counter == 3) {
                  board[i][j] = 3;
               }
            }
         }
      }

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == 2 || board[i][j] == 3) {
               board[i][j] = board[i][j] - 2;
            }
         }
      }
   }

   private static int getAmountOfOnesAround(int[][] board, int i, int j) {
      int counter = 0;

      for (int l = -1; l < 2; l = l + 2) {
         for (int k = -1; k < 2; k++) {
            if (i + l >= 0 && i + l < board.length && j + k >= 0 && j + k < board[0].length && isOne(board[i + l][j + k])) {
               counter++;
            }
         }
      }

      if (j + 1 >= 0 && j + 1 < board[0].length && isOne(board[i][j + 1])) {
         counter++;
      }
      if (j - 1 >= 0 && j - 1 < board[0].length && isOne(board[i][j - 1])) {
         counter++;
      }
      return counter;
   }

   private static boolean isOne(int i) {
      return i == 1 || i == 2;
   }
}
