package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {

   public static void main(String[] args) {

   }

   public static int[] findOrder(int numCourses, int[][] prerequisites) {
      List<Integer> list = new ArrayList<>();

      Map<Integer, List<Integer>> courseToDependency = new HashMap<>();
      Map<Integer, List<Integer>> dependencyToDependent = new HashMap<>();
      for (int[] prerequisite : prerequisites) {
         int course = prerequisite[0];
         int dependency = prerequisite[1];
         List<Integer> tmpDependencies = courseToDependency.getOrDefault(course, new ArrayList<>());
         tmpDependencies.add(dependency);
         courseToDependency.put(course, tmpDependencies);

         List<Integer> tmpDependent = dependencyToDependent.getOrDefault(dependency, new ArrayList<>());
         tmpDependent.add(course);
         dependencyToDependent.put(dependency, tmpDependent);
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < numCourses; i++) {
         if (!courseToDependency.containsKey(i)) {
            queue.add(i);
         }
      }
      while (!queue.isEmpty()) {
         Integer dep = queue.poll();
         list.add(dep);
         if (dependencyToDependent.containsKey(dep)) {
            for (Integer integer : dependencyToDependent.get(dep)) {
               List<Integer> dependencies = courseToDependency.get(integer);
               if (dependencies.size() == 1) {
                  queue.add(integer);
               } else {
                  dependencies.remove(dep);
                  courseToDependency.put(integer, dependencies);
               }
            }
         }
      }

      if (list.size() == numCourses) {
         int[] ints = new int[numCourses];
         for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
         }

         return ints;
      } else {
         return new int[]{};
      }
   }
}
