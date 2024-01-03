package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

public class SurroundedRegions {

   public void solve(char[][] board) {
      // mark all border related as 5
      for (int i = 0; i < board.length; i++) {
         dfs(i, 0, board);
      }
      for (int i = 0; i < board.length; i++) {
         dfs(i, board[0].length - 1, board);
      }
      for (int i = 0; i < board[0].length; i++) {
         dfs(0, i, board);
      }
      for (int i = 0; i < board[0].length; i++) {
         dfs(board.length - 1, i, board);
      }

      // mark all not 5 as X
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] != '5') {
               board[i][j] = 'X';
            }
         }
      }

      // mark all 5 as O
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == '5') {
               board[i][j] = 'O';
            }
         }
      }
   }

   private void dfs(int x, int y, char[][] board) {
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
         board[x][y] = '5';
         dfs(x + 1, y, board);
         dfs(x, y + 1, board);
         dfs(x - 1, y, board);
         dfs(x, y - 1, board);
      }
   }
}
