package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.design;

import java.util.Random;

public class ShuffleAnArray {

   /**
    * Your Solution object will be instantiated and called as such:
    * Solution obj = new Solution(nums);
    * int[] param_1 = obj.reset();
    * int[] param_2 = obj.shuffle();
    */
   static class Solution {

      private int[] initial;
      private int[] shuffled;
      private Random random = new Random();

      public Solution(int[] nums) {
         this.initial = nums;
         this.shuffled = nums.clone();
      }

      public int[] reset() {
         return initial;
      }

      public int[] shuffle() {
         for (int i = 0; i < shuffled.length / 2; i++) {
            swap(shuffled, randRange(i, shuffled.length), randRange(i, shuffled.length));
         }
         return shuffled;
      }

      private void swap(int[] arr, int in1, int in2) {
         int tmp = arr[in1];
         arr[in1] = arr[in2];
         arr[in2] = tmp;
      }

      private int randRange(int min, int max) {
         return random.nextInt(max - min) + min;
      }
   }
}
