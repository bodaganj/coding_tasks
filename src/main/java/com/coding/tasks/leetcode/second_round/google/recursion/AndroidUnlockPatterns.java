package com.coding.tasks.leetcode.second_round.google.recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AndroidUnlockPatterns {

   private static int count = 0;

   public static void main(String[] args) {
      System.out.println(numberOfPatterns(1, 1));
      System.out.println(numberOfPatterns(1, 2));
   }

   private static int numberOfPatterns(int m, int n) {
      count = 0;
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            Set<List<Integer>> visited = new HashSet<>();
            visited.add(List.of(i, j));
            dfs(visited, List.of(i, j), m, n);
            visited.remove(List.of(i, j));
         }
      }
      return count;
   }

   private static void dfs(Set<List<Integer>> visited, List<Integer> currentCoordinates, int min, int max) {
      if (visited.size() >= min && visited.size() <= max) {
         count++;
      }
      if (visited.size() == max) {
         return;
      }

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            List<Integer> potentialNextPoint = List.of(i, j);
            if (!visited.contains(potentialNextPoint) && !isCrossUnvisitedNodeCenter(currentCoordinates, potentialNextPoint, visited)) {
               visited.add(potentialNextPoint);
               dfs(visited, potentialNextPoint, min, max);
               visited.remove(potentialNextPoint);
            }
         }
      }
   }

   private static boolean isCrossUnvisitedNodeCenter(List<Integer> start, List<Integer> finish, Set<List<Integer>> visited) {
      return isRowIssue(start, finish, visited) ||
         isColumnIssue(start, finish, visited) ||
         isDiagonalIssue(start, finish, visited) ||
         isAntiDiagonalIssue(start, finish, visited);
   }

   private static boolean isRowIssue(List<Integer> start, List<Integer> finish, Set<List<Integer>> visited) {
      if (!start.get(0).equals(finish.get(0))) {
         return false;
      } else {
         if (Math.abs(finish.get(1) - start.get(1)) == 2) {
            return !visited.contains(List.of(start.get(0), 1));
         } else {
            return false;
         }
      }
   }

   private static boolean isColumnIssue(List<Integer> start, List<Integer> finish, Set<List<Integer>> visited) {
      if (!start.get(1).equals(finish.get(1))) {
         return false;
      } else {
         if (Math.abs(finish.get(0) - start.get(0)) == 2) {
            return !visited.contains(List.of(1, start.get(1)));
         } else {
            return false;
         }
      }
   }

   private static boolean isDiagonalIssue(List<Integer> start, List<Integer> finish, Set<List<Integer>> visited) {
      if (start.get(0) - start.get(1) != 0 || finish.get(0) - finish.get(1) != 0) {
         return false;
      } else {
         if (Math.abs(finish.get(0) - start.get(0)) == 2) {
            return !visited.contains(List.of(1, 1));
         } else {
            return false;
         }
      }
   }

   private static boolean isAntiDiagonalIssue(List<Integer> start, List<Integer> finish, Set<List<Integer>> visited) {
      if (Math.abs(start.get(0) - start.get(1)) != 2 || Math.abs(finish.get(0) - finish.get(1)) != 2) {
         return false;
      } else {
         return !visited.contains(List.of(1, 1));
      }
   }
}
