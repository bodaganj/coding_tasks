package com.coding.tasks.other;

import java.util.Arrays;

public class DutchFlag {

   public static void main(String[] args) {
      int[] array = new int[]{1, 1, 0, 0, 0, 1, 2, 0, 1, 0, 2, 2, 2};
      System.out.println(Arrays.toString(array));
      dutchFlag(array);
      System.out.println(Arrays.toString(array));
   }

   private static void dutchFlag(int a[]) {
      int length = a.length;
      int left = 0;
      int right = length - 1;
      int mid = 0;
      int temp;

      while (mid <= right) {
         switch (a[mid]) {
            case 0: {
               temp = a[left];
               a[left] = a[mid];
               a[mid] = temp;
               left++;
               mid++;
               break;
            }
            case 1:
               mid++;
               break;
            case 2: {
               temp = a[mid];
               a[mid] = a[right];
               a[right] = temp;
               right--;
               break;
            }
         }
      }
   }
}
