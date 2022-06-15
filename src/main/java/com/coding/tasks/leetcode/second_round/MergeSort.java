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
      sort(array, 0, array.length - 1);
   }

   private static void sort(int[] array, int left, int right) {
      if (left < right) {
         int mid = right - (right - left) / 2;
         sort(array, left, mid - 1);
         sort(array, mid, right);
         merge(array, left, mid, right);
      }
   }

   private static void merge(int[] array, int left, int mid, int right) {
      int[] tmp = new int[right - left + 1];

      int l = left;
      int r = mid;
      int i = 0;
      while (l < mid && r <= right) {
         if (array[l] < array[r]) {
            tmp[i] = array[l];
            l++;
         } else {
            tmp[i] = array[r];
            r++;
         }
         i++;
      }

      while (l < mid) {
         tmp[i] = array[l];
         i++;
         l++;
      }

      while (r <= right) {
         tmp[i] = array[r];
         i++;
         r++;
      }

      i = 0;
      while (i < tmp.length) {
         array[left + i] = tmp[i];
         i++;
      }
   }
}
