package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class MoveZeroes {

   public static void main(String[] args) {
      int[] array = new int[]{0, 1, 0, 3, 12};
      System.out.println(Arrays.toString(array));
      moveZeroes(array);
      System.out.println(Arrays.toString(array));
   }

   //   Input:  [0,1,0,3,12]
   //   Output: [1,3,12,0,0]
   private static void moveZeroes(int[] nums) {
   }
}
