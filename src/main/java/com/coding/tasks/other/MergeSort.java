package com.coding.tasks.other;

public class MergeSort {

   public static void main(String[] args) {
      int[] array1 = new int[]{2, 4, 3, 6, 7, 1};
      int[] array2 = new int[]{5, 4, 3, 2};
      int[] array3 = new int[]{1, 2, 3};

      for (int i : array1) {
         System.out.println(i);
      }
      System.out.println("=======");
      for (int i : array2) {
         System.out.println(i);
      }
      System.out.println("=======");
      for (int i : array3) {
         System.out.println(i);
      }
      System.out.println("=======");

      sort(array1, 0, array1.length - 1);
      sort(array2, 0, array2.length - 1);
      sort(array3, 0, array3.length - 1);

      System.out.println("After sorting");
      for (int i : array1) {
         System.out.println(i);
      }
      System.out.println("=======");
      for (int i : array2) {
         System.out.println(i);
      }
      System.out.println("=======");
      for (int i : array3) {
         System.out.println(i);
      }
      System.out.println("=======");
   }

   private static void sort(int[] array, int left, int right) {
      if (left < right) {
         int middle = left + (right - left) / 2;
         sort(array, left, middle);
         sort(array, middle + 1, right);
         merge(array, left, middle, right);
      }
   }

   private static void merge(int[] array, int left, int middle, int right) {
      int sizeLeft = middle - left + 1;
      int sizeRight = right - middle;

      int[] leftArray = new int[sizeLeft];
      int[] rightArray = new int[sizeRight];

      System.arraycopy(array, left, leftArray, 0, sizeLeft);
      System.arraycopy(array, middle + 1, rightArray, 0, sizeRight);

      int i = 0;
      int j = 0;
      int k = left;

      while (i < sizeLeft && j < sizeRight) {
         if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i];
            i++;
         } else {
            array[k] = rightArray[j];
            j++;
         }
         k++;
      }

      while (i < sizeLeft) {
         array[k] = leftArray[i];
         k++;
         i++;
      }

      while (j < sizeRight) {
         array[k] = rightArray[j];
         k++;
         j++;
      }
   }
}
