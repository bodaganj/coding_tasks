package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 4};
      Solution s = new Solution(arr);
      System.out.println(Arrays.toString(s.shuffle()));
      System.out.println(Arrays.toString(s.shuffle()));
      System.out.println(Arrays.toString(s.reset()));
      System.out.println(Arrays.toString(s.shuffle()));
   }

   static class Solution {

      private Random rand;
      private int[] init;
      private int[] curr;

      public Solution(int[] nums) {
         this.rand = new Random();
         this.init = Arrays.copyOf(nums, nums.length);
         this.curr = Arrays.copyOf(nums, nums.length);
      }

      public int[] reset() {
         this.curr = Arrays.copyOf(init, init.length);
         return this.curr;
      }

      public int[] shuffle() {
         for (int i = 0; i < curr.length; i++) {
            swap(i, rand.nextInt(curr.length));
         }
         return curr;
      }

      private void swap(int i, int j) {
         int tmp = curr[i];
         curr[i] = curr[j];
         curr[j] = tmp;
      }
   }
}
