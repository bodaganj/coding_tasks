package com.coding.tasks.leetcode.third_round.amazon.trees.and.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CutOffTreesForGolfEvent {

   private static int[][] matrix;
   private static final int[][] dirs = new int[][]{
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
   };
   private static int minSteps;

   public static void main(String[] args) {
      System.out.println(cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(8, 7, 6))));
      System.out.println(cutOffTree(List.of(List.of(2, 3, 4), List.of(0, 0, 5), List.of(8, 7, 6))));
   }

   public static int cutOffTree(List<List<Integer>> forest) {
      int minSteps = 0;
      if (forest.get(0).get(0) == 0) {
         return -1;
      }
      matrix = new int[forest.size()][forest.get(0).size()];
      for (int i = 0; i < forest.size(); i++) {
         for (int j = 0; j < forest.get(i).size(); j++) {
            matrix[i][j] = forest.get(i).get(j);
         }
      }

      List<Tree> trees = getTrees();
      trees.sort(Comparator.comparingInt(o -> o.height));

      List<Integer> prev = List.of(0, 0);
      for (Tree tree : trees) {
         List<Integer> current = List.of(tree.x, tree.y);
         int distance = distance(prev, current);
         if (distance == -1) {
            return -1;
         } else {
            minSteps += distance;
         }
         prev = current;
      }
      return minSteps;
   }

   private static int distance(List<Integer> prev, List<Integer> next) {
      minSteps = Integer.MAX_VALUE;
      dfs(prev.get(0), prev.get(1), next.get(0), next.get(1), 0, new HashSet<>());
      return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
   }

   private static void dfs(int xPrev, int yPrev, int xNext, int yNext, int currentSteps, Set<List<Integer>> seen) {
      if (xPrev == xNext && yPrev == yNext) {
         minSteps = Math.min(minSteps, currentSteps);
      } else {
         for (int[] dir : dirs) {
            int x = xPrev + dir[0];
            int y = yPrev + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !seen.contains(List.of(x, y)) && matrix[x][y] != 0) {
               seen.add(List.of(x, y));
               dfs(x, y, xNext, yNext, currentSteps + 1, seen);
               seen.remove(List.of(x, y));
            }
         }
      }
   }

   private static List<Tree> getTrees() {
      List<Tree> ans = new ArrayList<>();
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] > 1) {
               ans.add(new Tree(matrix[i][j], i, j));
            }
         }
      }
      return ans;
   }

   private record Tree(int height, int x, int y) {

   }
}
