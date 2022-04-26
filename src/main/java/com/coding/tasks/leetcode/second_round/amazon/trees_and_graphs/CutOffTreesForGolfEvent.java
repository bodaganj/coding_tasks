package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class CutOffTreesForGolfEvent {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(7, 6, 5))));
      System.out.println(cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 0), List.of(7, 6, 5))));
      System.out.println(cutOffTree(List.of(List.of(54581641, 64080174, 24346381, 69107959),
                                            List.of(86374198, 61363882, 68783324, 79706116),
                                            List.of(668150, 92178815, 89819108, 94701471),
                                            List.of(83920491, 22724204, 46281641, 47531096),
                                            List.of(89078499, 18904913, 25462145, 60813308)
      )));
   }

   private static int cutOffTree(List<List<Integer>> forest) {
      int[][] matrix = new int[forest.size()][forest.get(0).size()];
      Queue<Integer> pq = new PriorityQueue<>();
      for (int i = 0; i < forest.size(); i++) {
         for (int j = 0; j < forest.get(i).size(); j++) {
            matrix[i][j] = forest.get(i).get(j);
            if (forest.get(i).get(j) > 1) {
               pq.offer(forest.get(i).get(j));
            }
         }
      }

      Integer i = 0;
      Integer j = 0;
      int totalStepsAmount = 0;
      while (!pq.isEmpty()) {
         Integer target = pq.poll();
         List<Integer> bfs = bfs(target, matrix, i, j);
         if (bfs.get(0) == -1) {
            return -1;
         } else {
            i = bfs.get(1);
            j = bfs.get(2);
            totalStepsAmount += bfs.get(0);
         }
      }

      return totalStepsAmount;
   }

   private static List<Integer> bfs(int target, int[][] matrix, Integer i, Integer j) {
      List<Integer> curr = List.of(i, j);

      Queue<List<Integer>> queue = new LinkedList<>();
      queue.offer(curr);

      int steps = 0;

      Set<List<Integer>> visited = new HashSet<>();
      visited.add(curr);

      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            List<Integer> poll = queue.poll();
            if (matrix[poll.get(0)][poll.get(1)] == target) {
               return List.of(steps, poll.get(0), poll.get(1));
            }

            for (int[] dir : dirs) {
               int x = poll.get(0) + dir[0];
               int y = poll.get(1) + dir[1];
               List<Integer> newPair = List.of(x, y);
               if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] != 0 && !visited.contains(newPair)) {
                  queue.offer(newPair);
                  visited.add(newPair);
               }
            }

            size--;
         }

         steps++;
      }

      return List.of(-1, 0, 1);
   }
}
