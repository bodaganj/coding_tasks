package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.design;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleArray {

   int[] initial;
   int[] shuffle;

   public ShuffleArray(int[] nums) {
      this.initial = Arrays.copyOf(nums, nums.length);
      this.shuffle = Arrays.copyOf(nums, nums.length);
   }

   public int[] reset() {
      return initial;
   }

   public int[] shuffle() {
      for (int i = 0; i < shuffle.length; i++) {
         swap(i);
      }
      return shuffle;
   }

   private void swap(int left) {
      int right = ThreadLocalRandom.current().nextInt(0, shuffle.length);
      int tmp = shuffle[left];
      shuffle[left] = shuffle[right];
      shuffle[right] = tmp;
   }
}
