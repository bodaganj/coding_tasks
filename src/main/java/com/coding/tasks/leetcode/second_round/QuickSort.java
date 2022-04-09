package com.coding.tasks.leetcode.second_round;

import java.util.Arrays;

public class QuickSort {

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

      quickSort(arr1);
      System.out.println(Arrays.toString(arr1));

      quickSort(arr2);
      System.out.println(Arrays.toString(arr2));

      quickSort(arr3);
      System.out.println(Arrays.toString(arr3));

      quickSort(arr4);
      System.out.println(Arrays.toString(arr4));
   }

   private static void quickSort(int[] arr) {
      if (arr != null && arr.length != 0) {
         sort(arr, 0, arr.length - 1);
      }
   }

   private static void sort(int[] arr, int left, int right) {
      if (left < right) {
         int part = partition(arr, left, right);
         sort(arr, left, part - 1);
         sort(arr, part + 1, right);
      }
   }

   private static int partition(int[] arr, int left, int right) {
      int middle = left + (right - left) / 2;
      swap(arr, middle, right);
      int leftCounter = left;
      int rightCounter = right - 1;

      while (leftCounter <= rightCounter) {
         if (arr[leftCounter] > arr[rightCounter]) {
            swap(arr, leftCounter, rightCounter);
         }

         if (arr[leftCounter] < arr[right]) {
            leftCounter++;
         }
         if (arr[rightCounter] > arr[right]) {
            rightCounter--;
         }
      }

      swap(arr, leftCounter, right);

      return leftCounter;
   }

   private static void swap(int[] arr, int first, int second) {
      int tmp = arr[first];
      arr[first] = arr[second];
      arr[second] = tmp;
   }
}
