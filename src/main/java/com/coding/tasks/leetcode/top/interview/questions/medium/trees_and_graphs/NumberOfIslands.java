package com.coding.tasks.leetcode.top.interview.questions.medium.trees_and_graphs;

import java.util.Objects;

public class NumberOfIslands {

   public static void main(String[] args) {
      char[][] arr = new char[][]{
         {'1', '1', '0', '0', '0'},
         {'1', '1', '0', '0', '0'},
         {'0', '0', '1', '0', '0'},
         {'0', '0', '0', '1', '1'}
      };

      System.out.println(numIslands(arr));
   }

   private static int numIslands(char[][] grid) {
      if (Objects.isNull(grid) || grid.length == 0) {
         return 0;
      }
      int counter = 0;

      for (int row = 0; row < grid.length; row++) {
         for (int column = 0; column < grid[row].length; column++) {
            if (grid[row][column] == '1') {
               counter++;
               dfs(grid, row, column);
            }
         }
      }
      return counter;
   }

   private static void dfs(char[][] grid, int row, int column) {
      int rowAmount = grid.length;
      int columnAmount = grid[0].length;

      if (row < 0 || row >= rowAmount || column < 0 || column >= columnAmount || grid[row][column] == '0') {
         return;
      }

      grid[row][column] = '0';
      dfs(grid, row + 1, column);
      dfs(grid, row - 1, column);
      dfs(grid, row, column + 1);
      dfs(grid, row, column - 1);
   }
}
