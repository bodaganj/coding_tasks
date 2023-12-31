package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

public class GameOfLife {

   int wasDeadButShouldBeAlive = 5;
   int wasAliveButShouldBeDead = -5;

   public void gameOfLife(int[][] board) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            int liveNeighbors = getLiveNeighbors(i, j, board);
            if (isLive(i, j, board)) {
               if (liveNeighbors < 2 || liveNeighbors > 3) {
                  board[i][j] = wasAliveButShouldBeDead;
               }
            } else {
               if (liveNeighbors == 3) {
                  board[i][j] = wasDeadButShouldBeAlive;
               }
            }
         }
      }

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == wasAliveButShouldBeDead) {
               board[i][j] = 0;
            }
            if (board[i][j] == wasDeadButShouldBeAlive) {
               board[i][j] = 1;
            }
         }
      }
   }

   private boolean isLive(int x, int y, int[][] board) {
      return board[x][y] == 1 || board[x][y] == wasAliveButShouldBeDead;
   }

   private int getLiveNeighbors(int x, int y, int[][] board) {
      int[][] directions = new int[][]{
         {-1, -1},
         {-1, 0},
         {-1, 1},
         {0, 1},
         {1, 1},
         {1, 0},
         {1, -1},
         {0, -1}
      };

      int count = 0;
      for (int[] direction : directions) {
         int newX = x + direction[0];
         int newY = y + direction[1];
         if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && (board[newX][newY] == 1 || board[newX][newY] == wasAliveButShouldBeDead)) {
            count++;
         }
      }
      return count;
   }
}
