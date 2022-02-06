package com.coding.tasks.leetcode.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

   public static void main(String[] args) {
      System.out.println(canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
   }

   private static boolean canFinish(int numCourses, int[][] prerequisites) {
      if (prerequisites == null || prerequisites.length == 0) {
         return true;
      }

      int[] allCourses = new int[numCourses]; // S(N)
      Map<Integer, List<Integer>> mapping = new HashMap<>(); // S(N)

      for (int[] prerequisite : prerequisites) {
         int dependent = prerequisite[0];
         int independent = prerequisite[1];

         allCourses[dependent]++;

         List<Integer> list = mapping.getOrDefault(independent, new ArrayList<>());
         list.add(dependent);
         mapping.put(independent, list);
      }

      Set<Integer> doneCourses = new HashSet<>();
      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < allCourses.length; i++) {
         if (allCourses[i] == 0) {
            queue.offer(i);
            doneCourses.add(i);
         }
      }

      while (!queue.isEmpty()) {
         Integer poll = queue.poll();

         if (mapping.containsKey(poll)) {
            for (Integer integer : mapping.get(poll)) {
               allCourses[integer]--;

               if (allCourses[integer] == 0) {
                  queue.offer(integer);
                  doneCourses.add(integer);
               }
            }
         }

         if (doneCourses.size() == numCourses) {
            return true;
         }
      }

      return false;
   }
}
