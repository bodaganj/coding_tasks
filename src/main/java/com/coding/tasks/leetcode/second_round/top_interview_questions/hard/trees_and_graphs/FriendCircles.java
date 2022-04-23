package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

import java.util.HashSet;
import java.util.LinkedList;
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
    * 1. go for all cities (increment counter if not visited yet)
    * 2. mark the city and all its connected cities as visited
    * 3. return counter
    */
   private static int findCircleNum(int[][] isConnected) {
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
                  for (int j = 0; j < isConnected[0].length; j++) {
                     if (isConnected[poll][j] == 1) {
                        if (!visited.contains(j)) {
                           queue.offer(j);
                           visited.add(j);
                        }
                     }
                  }
               }
            }
         }
      }

      return counter;
   }
}
