package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.Arrays;

public class GameOfLife {

   public static void main(String[] args) {
      int[][] arr = {
         {0, 1, 0},
         {0, 0, 1},
         {1, 1, 1},
         {0, 0, 0},
      };

      System.out.println(Arrays.deepToString(arr));
      gameOfLife(arr);
      System.out.println("=====");
      System.out.println(Arrays.deepToString(arr));
   }

   private static void gameOfLife(int[][] board) {
   }
}
