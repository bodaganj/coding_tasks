package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.trees.and.graphs;

public class NumberOfIslands {

   public int numIslands(char[][] grid) {
      int count = 0;
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == '1') {
               count++;
               paint(grid, i, j);
            }
         }
      }
      return count;
   }

   private void paint(char[][] grid, int i, int j) {
      if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
         grid[i][j] = '2';
         paint(grid, i + 1, j);
         paint(grid, i - 1, j);
         paint(grid, i, j + 1);
         paint(grid, i, j - 1);
      }
   }
}
