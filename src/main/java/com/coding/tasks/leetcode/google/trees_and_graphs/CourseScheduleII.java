package com.coding.tasks.leetcode.google.trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
   }

   private static int[] findOrder(int numCourses, int[][] prerequisites) {
      // amount of dependencies per course
      int[] amountOfDependencies = new int[numCourses];

      // course -> dependent_courses mapping
      Map<Integer, List<Integer>> mapping = new HashMap<>();

      for (int[] prerequisite : prerequisites) {
         int dependent = prerequisite[0];
         int parent = prerequisite[1];

         amountOfDependencies[dependent]++;

         List<Integer> tmp = mapping.getOrDefault(parent, new ArrayList<>());
         tmp.add(dependent);
         mapping.put(parent, tmp);
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < amountOfDependencies.length; i++) {
         if (amountOfDependencies[i] == 0) {
            queue.offer(i);
         }
      }

      List<Integer> finalList = new ArrayList<>();
      while (!queue.isEmpty()) {
         Integer poll = queue.poll();
         finalList.add(poll);

         if (mapping.containsKey(poll)) {
            for (Integer integer : mapping.get(poll)) {
               amountOfDependencies[integer]--;

               if (amountOfDependencies[integer] == 0) {
                  queue.offer(integer);
               }
            }
         }
      }

      if (finalList.size() == numCourses) {
         return finalList.stream().mapToInt(c -> c).toArray();
      } else {
         return new int[0];
      }
   }
}
