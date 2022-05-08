package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.design;

public class DesignTicTacToe {

   public static void main(String[] args) {
      TicTacToe t = new TicTacToe(2);
      System.out.println(t.move(0, 0, 2));
      System.out.println(t.move(1, 1, 1));
      System.out.println(t.move(0, 1, 2));
   }

   static class TicTacToe {

      private int[][] matrix;

      public TicTacToe(int n) {
         matrix = new int[n][n];
      }

      public int move(int row, int col, int player) {
         matrix[row][col] = player;
         if (checkRow(row, player) || checkColumn(col, player) || checkDiagonal(player) || checkAntiDiagonal(player)) {
            return player;
         } else {
            return 0;
         }
      }

      private boolean checkRow(int row, int player) {
         for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] != player) {
               return false;
            }
         }
         return true;
      }

      private boolean checkColumn(int col, int player) {
         for (int[] ints : matrix) {
            if (ints[col] != player) {
               return false;
            }
         }
         return true;
      }

      private boolean checkDiagonal(int player) {
         for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != player) {
               return false;
            }
         }
         return true;
      }

      private boolean checkAntiDiagonal(int player) {
         for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length - 1 - i] != player) {
               return false;
            }
         }
         return true;
      }
   }
}
