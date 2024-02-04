package com.coding.tasks.leetcode.third_round.amazon.trees.and.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FloodFill {

   public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
      if (image[sr][sc] != color) {
         dfs(image, sr, sc, color, new HashSet<>());
      }
      return image;
   }

   private static void dfs(int[][] image, int sr, int sc, int color, Set<List<Integer>> seen) {
      int prev = image[sr][sc];
      image[sr][sc] = color;
      int[][] dirs = new int[][]{
         {1, 0},
         {-1, 0},
         {0, 1},
         {0, -1}
      };

      for (int[] dir : dirs) {
         int x = sr + dir[0];
         int y = sc + dir[1];
         if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && !seen.contains(List.of(x, y)) && image[x][y] == prev) {
            seen.add(List.of(x, y));
            dfs(image, x, y, color, seen);
         }
      }
   }
}
