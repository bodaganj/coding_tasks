package com.coding.tasks.cracking.the.code.arrays.and.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

   public static void main(String[] args) {
      int[][] array = new int[][]{
         {1, 2, 9, 4},
         {5, 6, 0, 8},
         {9, 4, 2, 4},
         {5, 3, 2, 4}
      };

      System.out.println("Before");
      for (int[] ints : array) {
         System.out.println(Arrays.toString(ints));
      }

      System.out.println("After");
      getMatrix(array);
      for (int[] ints : array) {
         System.out.println(Arrays.toString(ints));
      }
   }

   private static void getMatrix(int[][] matrix) {
      Set<Integer> rows = new HashSet<>();
      Set<Integer> columns = new HashSet<>();

      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 0) {
               rows.add(i);
               columns.add(j);
            }
         }
      }

      for (Integer row : rows) {
         for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
         }
      }

      for (Integer column : columns) {
         for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][column] = 0;
         }
      }
   }
}
