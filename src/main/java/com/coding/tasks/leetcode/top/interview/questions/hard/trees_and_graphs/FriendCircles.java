package com.coding.tasks.leetcode.top.interview.questions.hard.trees_and_graphs;

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
      System.out.println(findCircleNum(arr1));
      System.out.println(findCircleNum(arr2));
   }

   private static int findCircleNum(int[][] isConnected) {
      int length = isConnected.length;
      int amountOfProvinces = 0;

      return amountOfProvinces;
   }
}
