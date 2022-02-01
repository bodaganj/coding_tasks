package com.coding.tasks.leetcode.top.interview.questions.hard.trees_and_graphs;

import java.util.HashSet;
import java.util.Set;

public class CourseSchedule {

   public static void main(String[] args) {
      int[][] arr1 = new int[][]{
         {1, 0}
      };
      int[][] arr2 = new int[][]{
         {1, 0},
         {0, 1}
      };
      int[][] arr3 = new int[][]{
         {1, 4},
         {2, 4},
         {3, 1},
         {3, 2}
      };
//      System.out.println(canFinish(2, arr1));
//      System.out.println(canFinish(2, arr2));
      System.out.println(canFinish(5, arr3));
   }

   private static boolean canFinish(int numCourses, int[][] prerequisites) {
      if (numCourses < 2) {
         return true;
      }

      Set<Integer> seen = new HashSet<>();

      for (int[] prerequisite : prerequisites) {
         if (seen.contains(prerequisite[0])) {
            continue;
         }
         if (dfs(prerequisites, prerequisite[0], new HashSet<>(), seen)) {
            return false;
         }
      }

      return true;
   }

   private static boolean dfs(int[][] prerequisites, int current, Set<Integer> allCurrentsBefore, Set<Integer> seen) {
      seen.add(current);

      Set<Integer> dependencies = new HashSet<>();

      for (int[] prerequisite : prerequisites) {
         if (prerequisite[0] == current) {
            dependencies.add(prerequisite[1]);
         }
      }

      if (isDeadlock(allCurrentsBefore, dependencies)) {
         return true;
      }

      allCurrentsBefore.add(current);

      for (Integer dependency : dependencies) {
         if (dfs(prerequisites, dependency, allCurrentsBefore, seen)) {
            return true;
         }
      }

      return false;
   }

   private static boolean isDeadlock(Set<Integer> allCurrentsBefore, Set<Integer> dependencies) {
      for (Integer dependency : dependencies) {
         if (allCurrentsBefore.contains(dependency)) {
            return true;
         }
      }
      return false;
   }
}
