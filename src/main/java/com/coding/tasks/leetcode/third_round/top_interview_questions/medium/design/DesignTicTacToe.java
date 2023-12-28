package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.design;

public class DesignTicTacToe {

   class TicTacToe {

      private final int[] rows;
      private final int[] cols;
      private final int total;
      private int diagonal1;
      private int diagonal2;

      public TicTacToe(int n) {
         rows = new int[n];
         cols = new int[n];
         diagonal1 = 0;
         diagonal2 = 0;
         total = n;
      }

      public int move(int row, int col, int player) {
         if (player == 1) {
            rows[row] += 1;
            cols[col] += 1;
            if (row == col) {
               diagonal1++;
            }
            if (row + col == total - 1) {
               diagonal2++;
            }
            if (rows[row] == total || cols[col] == total || diagonal1 == total || diagonal2 == total) {
               return player;
            }
         } else {
            rows[row] -= 1;
            cols[col] -= 1;
            if (row == col) {
               diagonal1--;
            }
            if (row + col == total - 1) {
               diagonal2--;
            }
            if (Math.abs(rows[row]) == total || Math.abs(cols[col]) == total || Math.abs(diagonal1) == total || Math.abs(diagonal2) == total) {
               return player;
            }
         }
         return 0;
      }
   }
}
