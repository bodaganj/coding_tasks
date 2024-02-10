package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.*;

public class ShortestDistanceFromAllBuildings {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
   private static int shortest = Integer.MAX_VALUE;
   private static int[][] matrix;

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
      matrix = grid;
      shortest = Integer.MAX_VALUE;
      List<Pair> emptySlots = new ArrayList<>();
      List<Pair> buildings = new ArrayList<>();
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (matrix[i][j] == 0) {
               emptySlots.add(new Pair(i, j));
            } else if (matrix[i][j] == 1) {
               buildings.add(new Pair(i, j));
            }
         }
      }
      if (emptySlots.isEmpty()) {
         return -1;
      }

      for (Pair emptySlot : emptySlots) {
         int currentShortest = getShortest(emptySlot, buildings);
         if (currentShortest > 0) {
            shortest = Math.min(shortest, currentShortest);
         }
      }
      return shortest == Integer.MAX_VALUE ? -1 : shortest;
   }

   private static int getShortest(Pair emptySlot, List<Pair> allBuildings) {
      int sum = 0;
      for (Pair building : allBuildings) {
         Set<Pair> set = new HashSet<>();
         set.add(emptySlot);
         int distance = getDistanceToBuilding(emptySlot, building, 0, set);
         if (distance > 0) {
            sum += distance;
         } else {
            return -1;
         }
      }
      return sum;
   }

   private static int getDistanceToBuilding(Pair nextSlot, Pair building, int count, Set<Pair> seen) {
      if (nextSlot.equals(building)) {
         return count;
      } else if (matrix[nextSlot.x][nextSlot.y] == 1){
         return -1;
      } else {
         int currentMin = Integer.MAX_VALUE;

         for (int[] dir : dirs) {
            int x = nextSlot.x + dir[0];
            int y = nextSlot.y + dir[1];
            Pair pair = new Pair(x, y);
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] != 2 && !seen.contains(pair)) {
               seen.add(pair);
               int distanceToBuilding = getDistanceToBuilding(pair, building, count + 1, seen);
               if (distanceToBuilding > 0) {
                  currentMin = Math.min(currentMin, distanceToBuilding);
               }
               seen.remove(pair);
            }
         }
         return currentMin == Integer.MAX_VALUE ? -1 : currentMin;
      }
   }

   private record Pair(int x, int y) {

   }
}
