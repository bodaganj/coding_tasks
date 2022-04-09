package com.coding.tasks.leetcode.second_round;

import java.util.Arrays;

public class MergeSort {

   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 2, 3, 4, 5};
      int[] arr2 = new int[]{5, 4, 3, 2, 1};
      int[] arr3 = new int[]{2, 5, 1, 3, 4};
      int[] arr4 = new int[]{};
      System.out.println(Arrays.toString(arr1));
      System.out.println(Arrays.toString(arr2));
      System.out.println(Arrays.toString(arr3));
      System.out.println(Arrays.toString(arr4));

      System.out.println("=======");

      mergeSort(arr1);
      System.out.println(Arrays.toString(arr1));

      mergeSort(arr2);
      System.out.println(Arrays.toString(arr2));

      mergeSort(arr3);
      System.out.println(Arrays.toString(arr3));

      mergeSort(arr4);
      System.out.println(Arrays.toString(arr4));
   }

   private static void mergeSort(int[] array) {
      if (array == null || array.length == 0) {
         return;
      }
      sort(array, 0, array.length - 1);
   }

   private static void sort(int[] array, int left, int right) {
      if (left != right) {
         int middle = left + (right - left) / 2;

         sort(array, left, middle);
         sort(array, middle + 1, right);
         merge(array, left, middle + 1, right);
      }
   }

   private static void merge(int[] array, int left, int middle, int right) {
      int[] ans = new int[right - left + 1];
      int i = 0;

      int counterLeft = left;
      int counterRight = middle;

      while (counterLeft < middle && counterRight <= right) {
         if (array[counterLeft] < array[counterRight]) {
            ans[i] = array[counterLeft];
            counterLeft++;
         } else {
            ans[i] = array[counterRight];
            counterRight++;
         }
         i++;
      }

      while (counterLeft < middle) {
         ans[i] = array[counterLeft];
         counterLeft++;
         i++;
      }

      while (counterRight <= right) {
         ans[i] = array[counterRight];
         counterRight++;
         i++;
      }

      int j = 0;
      int counter = left;
      while (j < ans.length) {
         array[counter] = ans[j];
         j++;
         counter++;
      }
   }
}
