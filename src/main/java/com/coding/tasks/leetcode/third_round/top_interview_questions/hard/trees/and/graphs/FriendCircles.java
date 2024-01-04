package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

public class FriendCircles {

   public static void main(String[] args) {
      System.out.println(findCircleNum(new int[][]{
         {1, 1, 0},
         {1, 1, 0},
         {0, 0, 1}
      }));
   }

   public static int findCircleNum(int[][] isConnected) {
      int count = 0;

      for (int i = 0; i < isConnected.length; i++) {
         for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1) {
               count++;
               dfs(i, j, isConnected);
            }
         }
      }

      return count;
   }

   private static void dfs(int i, int j, int[][] isConnected) {
      if (i >= 0 && i < isConnected.length && j >= 0 && j < isConnected.length && isConnected[i][j] == 1) {
         isConnected[i][j] = isConnected[j][i] = 0;
         for (int x = 0; x < isConnected.length; x++) {
            dfs(i, x, isConnected);
            dfs(x, j, isConnected);
         }
      }
   }
}
