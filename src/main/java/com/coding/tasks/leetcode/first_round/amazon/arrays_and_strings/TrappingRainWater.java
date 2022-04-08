package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

import java.util.stream.IntStream;

public class TrappingRainWater {

   public static void main(String[] args) {
      System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
   }

   private static int trap(int[] height) {
      int[] finalArray = new int[height.length];

      int currentMax = Integer.MIN_VALUE;
      for (int i = 0; i < height.length; i++) {
         if (height[i] >= currentMax) {
            finalArray[i] = 0;
            currentMax = height[i];
         } else {
            finalArray[i] = currentMax - height[i];
         }
      }

      currentMax = Integer.MIN_VALUE;
      for (int i = height.length - 1; i >= 0; i--) {
         if (height[i] >= currentMax) {
            finalArray[i] = 0;
            currentMax = height[i];
         } else {
            finalArray[i] = Math.min(finalArray[i], currentMax - height[i]);
         }
      }

      return IntStream.of(finalArray).sum();
   }

//   private static int trap(int[] height) {
//      int[] waterFromLeftSide = new int[height.length];
//      int[] waterFromRightSide = new int[height.length];
//
//      int currentMax = Integer.MIN_VALUE;
//      for (int i = 0; i < height.length; i++) {
//         if (height[i] >= currentMax) {
//            waterFromLeftSide[i] = 0;
//            currentMax = height[i];
//         } else {
//            waterFromLeftSide[i] = currentMax - height[i];
//         }
//      }
//
//      currentMax = Integer.MIN_VALUE;
//      for (int i = height.length - 1; i >= 0; i--) {
//         if (height[i] >= currentMax) {
//            waterFromRightSide[i] = 0;
//            currentMax = height[i];
//         } else {
//            waterFromRightSide[i] = currentMax - height[i];
//         }
//      }
//
//      int result = 0;
//      for (int i = 0; i < height.length; i++) {
//         result = result + Math.min(waterFromLeftSide[i], waterFromRightSide[i]);
//      }
//      return result;
//   }
}
