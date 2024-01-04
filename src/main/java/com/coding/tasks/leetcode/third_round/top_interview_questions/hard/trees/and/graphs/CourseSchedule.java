package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

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
//      System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
      System.out.println(canFinish(2, new int[][]{{1, 0}}));
   }

   public static boolean canFinish(int numCourses, int[][] prerequisites) {
      // 1. make map course -> dependencies and make a map of dependency -> dependent courses
      // 2. make set of done courses
      // 3. create queue and put there all courses without dependencies
      // 4. while queue is not empty get course, set it to done set
      //        remove this dependency from all dependent courses
      //          if course has no more dependency, add it to queue
      // return set.size() == numCourses

      Set<Integer> set = new HashSet<>();

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
         set.add(dep);
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

      return set.size() == numCourses;
   }
}
