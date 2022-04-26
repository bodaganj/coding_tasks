package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FloodFill {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
   }

   private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      Queue<List<Integer>> queue = new LinkedList<>();
      queue.offer(List.of(sr, sc));
      Set<List<Integer>> visited = new HashSet<>();

      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            List<Integer> poll = queue.poll();
            int curr = image[poll.get(0)][poll.get(1)];
            image[poll.get(0)][poll.get(1)] = newColor;
            visited.add(poll);

            for (int[] dir : dirs) {
               int x = poll.get(0) + dir[0];
               int y = poll.get(1) + dir[1];
               if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && !visited.contains(List.of(x, y)) && image[x][y] == curr) {
                  queue.offer(List.of(x, y));
               }
            }

            size--;
         }
      }

      return image;
   }
}
