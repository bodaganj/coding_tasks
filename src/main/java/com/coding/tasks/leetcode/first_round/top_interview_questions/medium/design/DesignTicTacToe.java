package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.design;

public class DesignTicTacToe {

   public static void main(String[] args) {
      TicTacToe t = new TicTacToe(2);
      System.out.println(t.move(0, 0, 2));
      System.out.println(t.move(1, 1, 1));
      System.out.println(t.move(0, 1, 2));
   }

   /**
    * Your TicTacToe object will be instantiated and called as such:
    * TicTacToe obj = new TicTacToe(n);
    * int param_1 = obj.move(row,col,player);
    */
   static class TicTacToe {

      private int[][] arr;
      private int length;

      public TicTacToe(int n) {
         arr = new int[n][n];
         length = n;
      }

      public int move(int row, int col, int player) {
         arr[row][col] = player;

         boolean isHorizontal = false;
         for (int y = 0; y < length; y++) {
            isHorizontal = arr[row][y] == player;
            if (!isHorizontal) {
               break;
            }
         }
         if (isHorizontal) {
            return player;
         }

         boolean isVertical = false;
         for (int x = 0; x < length; x++) {
            isVertical = arr[x][col] == player;
            if (!isVertical) {
               break;
            }
         }
         if (isVertical) {
            return player;
         }

         boolean isDiagonal1 = false;
         for (int i = 0; i < length; i++) {
            isDiagonal1 = arr[i][i] == player;
            if (!isDiagonal1) {
               break;
            }
         }
         if (isDiagonal1) {
            return player;
         }

         boolean isDiagonal2 = false;
         for (int i = 0; i < length; i++) {
            isDiagonal2 = arr[i][length - i - 1] == player;
            if (!isDiagonal2) {
               break;
            }
         }
         if (isDiagonal2) {
            return player;
         }

         return 0;
      }
   }
}
