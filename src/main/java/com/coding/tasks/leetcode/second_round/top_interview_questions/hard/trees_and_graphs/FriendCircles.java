package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FriendCircles {

   public static void main(String[] args) {
      int[][] arr1 = new int[][]{
         {1, 1, 0},
         {1, 1, 0},
         {0, 0, 1}
      };
      int[][] arr2 = new int[][]{
         {1, 0, 0},
         {0, 1, 0},
         {0, 0, 1}
      };
      int[][] arr3 = new int[][]{
         {1, 1, 1},
         {1, 1, 1},
         {1, 1, 1}
      };

      int[][] arr4 = new int[][]{
         {1, 0, 0, 1},
         {0, 1, 1, 0},
         {0, 1, 1, 1},
         {1, 0, 1, 1}
      };
      System.out.println(findCircleNum(arr1));
      System.out.println(findCircleNum(arr2));
      System.out.println(findCircleNum(arr3));
      System.out.println(findCircleNum(arr4));
   }

   /**
    * 1. create list of all connected cities
    * 2. go for all cities (increment counter if not visited yet)
    * 3. mark the city and all its connected cities as visited
    * 4. return counter
    */
   private static int findCircleNum(int[][] isConnected) {
      Map<Integer, List<Integer>> mapping = createMapping(isConnected);

      int counter = 0;
      Set<Integer> visited = new HashSet<>();
      for (int i = 0; i < isConnected.length; i++) {
         if (!visited.contains(i)) {
            counter++;
            visited.add(i);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            while (!queue.isEmpty()) {
               int size = queue.size();
               while (size > 0) {
                  size--;
                  Integer poll = queue.poll();
                  List<Integer> tmp = mapping.get(poll);
                  for (Integer integer : tmp) {
                     if (!visited.contains(integer)) {
                        queue.offer(integer);
                        visited.add(integer);
                     }
                  }
               }
            }
         }
      }

      return counter;
   }

   private static Map<Integer, List<Integer>> createMapping(int[][] isConnected) {
      Map<Integer, List<Integer>> mapping = new HashMap<>();
      for (int i = 0; i < isConnected.length; i++) {
         for (int j = i; j < isConnected[0].length; j++) {
            if (isConnected[i][j] == 1) {
               List<Integer> tmpI = mapping.getOrDefault(i, new ArrayList<>());
               tmpI.add(j);
               mapping.put(i, tmpI);

               List<Integer> tmpJ = mapping.getOrDefault(j, new ArrayList<>());
               tmpJ.add(i);
               mapping.put(j, tmpJ);
            }
         }
      }
      return mapping;
   }
}
