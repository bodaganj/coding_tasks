package com.coding.tasks.leetcode.top.interview.questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
      // 1. Create mapping course -> all courses that are dependent
      //    Create an array with amount of dependencies per course

      // 2. Crate queue and add to it all courses which are independent

      // 3. while queue is not empty
      //   1. poll element
      //   2. add it to final list (if final list size == number of courses - return list)
      //   3. get list of dependent courses from mapping and decrease amount of dependencies
      //   4. if amount of dep = 0, add this course to queue

      // 4. return empty array

      // 1
      int[] finalArray = new int[numCourses];
      int[] amountOfDependencies = new int[numCourses];
      Map<Integer, List<Integer>> mapping = new HashMap<>();
      for (int[] prerequisite : prerequisites) {
         List<Integer> list = mapping.getOrDefault(prerequisite[1], new ArrayList<>());
         list.add(prerequisite[0]);
         mapping.put(prerequisite[1], list);

         amountOfDependencies[prerequisite[0]] += 1;
      }

      // 2
      Queue<Integer> independentCoursesQueue = new LinkedList<>();
      for (int i = 0; i < amountOfDependencies.length; i++) {
         if (amountOfDependencies[i] == 0) {
            independentCoursesQueue.offer(i);
         }
      }

      // 3
      int counter = 0;
      while (!independentCoursesQueue.isEmpty()) {
         Integer poll = independentCoursesQueue.poll();
         finalArray[counter++] = poll;

         if (counter == numCourses) {
            return finalArray;
         }

         if (mapping.containsKey(poll)) {
            for (Integer integer : mapping.get(poll)) {
               amountOfDependencies[integer] -= 1;
               if (amountOfDependencies[integer] == 0) {
                  independentCoursesQueue.offer(integer);
               }
            }
         }
      }

      // 5
      return new int[0];
   }
}
