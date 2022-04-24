package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

   public static void main(String[] args) {
      int[][] arr1 = new int[][]{
         {1, 0},
         {2, 0},
         {3, 1},
         {3, 2}
      };

      int[][] arr2 = new int[][]{
         {1, 0}
      };

      int[][] arr3 = new int[][]{
         {1, 0},
         {0, 1}
      };

      System.out.println(Arrays.toString(findOrder(4, arr1)));
      System.out.println(Arrays.toString(findOrder(2, arr2)));
      System.out.println(Arrays.toString(findOrder(2, arr3)));
      System.out.println(Arrays.toString(findOrder(2, new int[][]{})));
   }

   private static int[] findOrder(int numCourses, int[][] prerequisites) {
      Map<Integer, Set<Integer>> mapping = constructMapping(prerequisites);
      int[] ans = new int[numCourses];

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < numCourses; i++) {
         if (!mapping.containsKey(i)) {
            queue.offer(i);
         }
      }

      int counter = 0;
      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            size--;
            Integer poll = queue.poll();
            ans[counter++] = poll;

            for (Map.Entry<Integer, Set<Integer>> entry : mapping.entrySet()) {
               entry.getValue().remove(poll);
            }

            List<Integer> noDependenciesCourses = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> entry : mapping.entrySet()) {
               if (entry.getValue().isEmpty()) {
                  queue.offer(entry.getKey());
                  noDependenciesCourses.add(entry.getKey());
               }
            }
            for (Integer noDependenciesCourse : noDependenciesCourses) {
               mapping.remove(noDependenciesCourse);
            }
         }
      }

      return mapping.isEmpty() ? ans : new int[0];
   }

   private static Map<Integer, Set<Integer>> constructMapping(int[][] prerequisites) {
      Map<Integer, Set<Integer>> mapping = new HashMap<>();
      for (int[] prerequisite : prerequisites) {
         Set<Integer> tmp = mapping.getOrDefault(prerequisite[0], new HashSet<>());
         tmp.add(prerequisite[1]);
         mapping.put(prerequisite[0], tmp);
      }

      for (Map.Entry<Integer, Set<Integer>> entry : mapping.entrySet()) {
         Set<Integer> newSet = new HashSet<>();
         for (Integer integer : entry.getValue()) {
            if (mapping.containsKey(integer)) {
               newSet.addAll(mapping.get(integer));
            }
         }
         entry.getValue().addAll(newSet);
      }
      return mapping;
   }
}
