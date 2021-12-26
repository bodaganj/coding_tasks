package com.coding.tasks.other;

import java.util.Arrays;

public class QuickSort {

   public static void main(String[] args) {
      int[] array1 = new int[]{1, 2, 3, 4, 5};
      int[] array2 = new int[]{7, 5, 4, 3, 1};
      int[] array3 = new int[]{4, 7, 5, 2, 9, 6, 1};

      System.out.println(Arrays.toString(array1));
      System.out.println(Arrays.toString(array2));
      System.out.println(Arrays.toString(array3));

      sort(array1, 0, array1.length - 1);
      sort(array2, 0, array2.length - 1);
      sort(array3, 0, array3.length - 1);

      System.out.println("=======");
      System.out.println(Arrays.toString(array1));
      System.out.println(Arrays.toString(array2));
      System.out.println(Arrays.toString(array3));
   }

   private static void sort(int[] array, int left, int right) {
      if (left < right) {
         int pivot = pivot(array, left, right);

         sort(array, left, pivot - 1);
         sort(array, pivot + 1, right);
      }
   }

   private static int pivot(int[] array, int left, int right) {
      int pivot = array[right];

      int i = left;
      int j = right - 1;
      while (i < j) {
         if (array[i] > pivot && array[j] < pivot) {
            swap(array, i, j);
         } else if (array[i] > pivot && array[j] >= pivot) {
            j--;
         } else {
            i++;
         }
      }

      for (int k = left; k < right; k++) {
         if (array[k] > pivot) {
            swap(array, k, right);
            return k;
         }
      }
      return right;
   }

   private static void swap(int[] array, int left, int right) {
      int tmp = array[left];
      array[left] = array[right];
      array[right] = tmp;
   }
}
