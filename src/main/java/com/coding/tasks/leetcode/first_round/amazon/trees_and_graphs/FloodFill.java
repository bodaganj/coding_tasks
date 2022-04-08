package com.coding.tasks.leetcode.first_round.amazon.trees_and_graphs;

import java.util.Arrays;

public class FloodFill {

   private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
   }

   private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      if (image == null || image.length == 0 || image[sr][sc] == newColor) {
         return image;
      }

      dfs(image, sr, sc, newColor);
      return image;
   }

   private static void dfs(int[][] image, int sr, int sc, int newColor) {
      int prev = image[sr][sc];
      image[sr][sc] = newColor;

      for (int[] ints : dir) {
         int i = sr + ints[0];
         int j = sc + ints[1];

         if (i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == prev) {
            dfs(image, i, j, newColor);
         }
      }
   }
}
