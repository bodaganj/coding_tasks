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
         Set<Pair> set = new HashSet<>();
         set.add(emptySlot);
         int distance = getDistanceToBuilding(emptySlot, building, grid, 1, memo, set);
         if (distance == 0) {
            return 0;
         } else {
            sum += distance;
         }
      }
      return sum;
   }

   private static int getDistanceToBuilding(Pair nextSlot, Pair building, int[][] grid, int count, Map<List<Pair>, Integer> memo, Set<Pair> seen) {
      if (memo.containsKey(List.of(nextSlot, building))) {
         return memo.get(List.of(nextSlot, building));
      }

      if (nextSlot.equals(building)) {
         return count;
      } else if (grid[nextSlot.x][nextSlot.y] == 1){
         return 0;
      } else {
         int currentMin = Integer.MAX_VALUE;

         for (int[] dir : dirs) {
            int x = nextSlot.x + dir[0];
            int y = nextSlot.y + dir[1];
            Pair pair = new Pair(x, y);
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 2 && !seen.contains(pair)) {
               seen.add(pair);
               int distanceToBuilding = getDistanceToBuilding(pair, building, grid, count + 1, memo, seen);
               if (distanceToBuilding > 0) {
                  currentMin = Math.min(currentMin, count + distanceToBuilding);
               }
               seen.remove(pair);
            }
         }
         memo.put(List.of(nextSlot, building), currentMin);
         System.out.println("Path from " + nextSlot.x + ":" + nextSlot.y + " to building " + building.x + ":" + building.y + " is - " + currentMin);
         return currentMin;
      }
   }

   private record Pair(int x, int y) {

   }
}
