package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

public class NumberOfIslands {

   private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
      int counter = 0;
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == '1') {
               counter++;
               dfs(grid, i, j);
            }
         }
      }
      return counter;
   }

   private static void dfs(char[][] grid, int i, int j) {
      if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
         grid[i][j] = '2';
         for (int[] ints : dir) {
            dfs(grid, i + ints[0], j + ints[1]);
         }
      }
   }
}
