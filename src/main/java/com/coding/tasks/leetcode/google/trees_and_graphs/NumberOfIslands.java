package com.coding.tasks.leetcode.google.trees_and_graphs;

import java.util.Objects;

public class NumberOfIslands {

   /**
    * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    * You may assume all four edges of the grid are all surrounded by water.
    * @param args
    */
   public static void main(String[] args) {
      char[][] test1 = {
         {'1', '1', '1', '1', '0'},
         {'1', '1', '0', '1', '0'},
         {'1', '1', '0', '0', '0'},
         {'0', '0', '0', '0', '0'}
      };
      char[][] test2 = {
         {'1', '1', '0', '0', '0'},
         {'1', '1', '0', '0', '0'},
         {'0', '0', '1', '0', '0'},
         {'0', '0', '0', '1', '1'}
      };

      System.out.println(numIslands(test1));
      System.out.println(numIslands(test2));
   }

   /**
    * Intuition
    * Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes of value '1'.
    * <p>
    * Algorithm
    * Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search.
    * During DFS, every visited node should be set as '0' to mark as visited node.
    * Count the number of root nodes that trigger DFS, this number would be the number of islands since each DFS starting at some root identifies an island.
    */
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
