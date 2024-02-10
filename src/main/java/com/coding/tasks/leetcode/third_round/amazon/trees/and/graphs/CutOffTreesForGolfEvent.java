package com.coding.tasks.leetcode.third_round.amazon.trees.and.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CutOffTreesForGolfEvent {

   private static int[][] matrix;
   private static final int[][] dirs = new int[][]{
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
   };

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

      Pair prev = new Pair(0, 0);
      for (Tree tree : trees) {
         Pair current = new Pair(tree.x, tree.y);
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

   private static int distance(Pair prev, Pair next) {
      int minSteps = 0;
      boolean flag = false;

      Queue<Pair> queue = new LinkedList<>();
      queue.add(prev);
      Set<Pair> seen = new HashSet<>();

      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            Pair poll = queue.poll();
            if (poll.x == next.x && poll.y == next.y) {
               flag = true;
               break;
            } else {
               for (int[] dir : dirs) {
                  int x = poll.x + dir[0];
                  int y = poll.y + dir[1];
                  Pair pair = new Pair(x, y);
                  if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !seen.contains(pair) && matrix[x][y] != 0) {
                     seen.add(pair);
                     queue.add(pair);
                  }
               }
            }
            size--;
         }
         if (flag) {
            return minSteps;
         }
         minSteps++;
      }

      return -1;
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

   private record Pair(int x, int y) {

   }
}
