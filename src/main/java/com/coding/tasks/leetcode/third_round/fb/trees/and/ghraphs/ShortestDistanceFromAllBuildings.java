package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.*;

public class ShortestDistanceFromAllBuildings {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
   private static Map<List<Pair>, Integer> memo = new HashMap<>();
   private static int shortest = Integer.MAX_VALUE;

   public static void main(String[] args) {
      int[][] grid1 = new int[][]{
         {1, 0, 2, 0, 1},
         {0, 0, 0, 0, 0},
         {0, 0, 1, 0, 0},
      };
      System.out.println(shortestDistance(grid1));

//      int[][] grid2 = new int[][]{
//         {1, 2, 0}
//      };
//      System.out.println(shortestDistance(grid2));
   }

   public static int shortestDistance(int[][] grid) {
      memo = new HashMap<>();
      shortest = Integer.MAX_VALUE;
      List<Pair> emptySlots = new ArrayList<>();
      List<Pair> buildings = new ArrayList<>();
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 0) {
               emptySlots.add(new Pair(i, j));
            } else if (grid[i][j] == 1) {
               buildings.add(new Pair(i, j));
            }
         }
      }
      if (emptySlots.isEmpty()) {
         return -1;
      }

      for (Pair emptySlot : emptySlots) {
         int currentShortest = getShortest(emptySlot, buildings, grid);
         if (currentShortest > 0) {
            shortest = Math.min(shortest, currentShortest);
         }
      }
      return shortest == Integer.MAX_VALUE ? -1 : shortest;
   }

   private static int getShortest(Pair emptySlot, List<Pair> allBuildings, int[][] grid) {
      int sum = 0;
      for (Pair building : allBuildings) {
         int distance = getDistanceToBuilding(emptySlot, building, grid);
         if (distance == 0) {
            return 0;
         } else {
            sum += distance;
         }
      }
      return sum;
   }

   private static int getDistanceToBuilding(Pair emptySlot, Pair building, int[][] grid) {
      if (memo.containsKey(List.of(emptySlot, building))) {
         return memo.get(List.of(emptySlot, building));
      }
      int count = 0;
      Queue<Pair> queue = new LinkedList<>();
      for (int[] dir : dirs) {
         int x = emptySlot.x + dir[0];
         int y = emptySlot.y + dir[1];
         if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 2) {
            queue.add(new Pair(x, y));
         }
      }

      Set<Pair> seen = new HashSet<>();
      seen.add(emptySlot);
      while (!queue.isEmpty()) {
         count++;
         if (count > shortest) {
            return 0;
         }
         int size = queue.size();
         while (size > 0) {
            Pair poll = queue.poll();
            seen.add(poll);
            if (poll.equals(building)) {
               memo.put(List.of(emptySlot, building), count);
               return count;
            } else {
               if (grid[poll.x][poll.y] != 1) {
                  for (int[] dir : dirs) {
                     int x = poll.x + dir[0];
                     int y = poll.y + dir[1];
                     if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 2 && !seen.contains(new Pair(
                        x, y))) {
                        seen.add(new Pair(x, y));
                        queue.add(new Pair(x, y));
                     }
                  }
               }
            }
            size--;
         }
      }
      memo.put(List.of(emptySlot, building), 0);
      return 0;
   }

   private record Pair(int x, int y) {

   }
}
