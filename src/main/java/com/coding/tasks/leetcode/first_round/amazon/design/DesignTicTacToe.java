package com.coding.tasks.leetcode.first_round.amazon.design;

public class DesignTicTacToe {

   public static void main(String[] args) {
      TicTacToe t = new TicTacToe(2);
      System.out.println(t.move(0, 0, 2));
      System.out.println(t.move(1, 1, 1));
      System.out.println(t.move(0, 1, 2));
   }

   static class TicTacToe {

      public int[][] arr;
      private int length;

      public TicTacToe(int n) {
         this.arr = new int[n][n];
         this.length = n;
      }

      public int move(int row, int col, int player) {
         arr[row][col] = player;

         if (isFullRow(row, player) || isFullColumn(col, player) || isFullDiagonal(player) || isFullAntiDiagonal(player)) {
            return player;
         } else {
            return 0;
         }
      }

      private boolean isFullRow(int row, int player) {
         for (int i = 0; i < length; i++) {
            if (arr[row][i] != player) {
               return false;
            }
         }
         return true;
      }

      private boolean isFullColumn(int col, int player) {
         for (int i = 0; i < length; i++) {
            if (arr[i][col] != player) {
               return false;
            }
         }
         return true;
      }

      private boolean isFullDiagonal(int player) {
         for (int i = 0; i < length; i++) {
            if (arr[i][i] != player) {
               return false;
            }
         }
         return true;
      }

      private boolean isFullAntiDiagonal(int player) {
         for (int i = 0; i < length; i++) {
            if (arr[i][length - i - 1] != player) {
               return false;
            }
         }
         return true;
      }
   }
}
