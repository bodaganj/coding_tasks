package com.coding.tasks.leetcode.top.interview.questions.hard.strings_and_arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

   public static void main(String[] args) {
      System.out.println(spiralOrder(new int[][]{
         {1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 10, 11, 12}
      }));

      System.out.println(spiralOrder(new int[][]{{3}, {2}}));
   }

   private static List<Integer> spiralOrder(int[][] matrix) {
      int expectedNumber = matrix.length * matrix[0].length;
      int counter = 0;
      List<Integer> result = new ArrayList<>();

      int k = 0;
      while (counter != expectedNumber) {
         List<Integer> firstRow = getFirstRow(matrix, k, expectedNumber - counter);
         counter += firstRow.size();
         result.addAll(firstRow);

         List<Integer> lastColumn = getLastColumn(matrix, k, expectedNumber - counter);
         counter += lastColumn.size();
         result.addAll(lastColumn);

         List<Integer> lastRow = getLastRow(matrix, k, expectedNumber - counter);
         counter += lastRow.size();
         result.addAll(lastRow);

         List<Integer> firstColumn = getFirstColumn(matrix, k, expectedNumber - counter);
         counter += firstColumn.size();
         result.addAll(firstColumn);

         k++;
      }

      return result;
   }

   private static List<Integer> getFirstRow(int[][] matrix, int k, int numberOfNeededItems) {
      List<Integer> res = new ArrayList<>();
      int counter = 0;
      for (int j = k; j < matrix[0].length - 1 - k; j++) {
         if (counter == numberOfNeededItems) {
            return res;
         }
         res.add(matrix[k][j]);
         counter++;
      }
      return res;
   }

   private static List<Integer> getLastColumn(int[][] matrix, int k, int numberOfNeededItems) {
      List<Integer> res = new ArrayList<>();
      int counter = 0;
      for (int i = k; i < matrix.length - k; i++) {
         if (counter == numberOfNeededItems) {
            return res;
         }
         res.add(matrix[i][matrix[k].length - 1 - k]);
         counter++;
      }
      return res;
   }

   private static List<Integer> getLastRow(int[][] matrix, int k, int numberOfNeededItems) {
      List<Integer> res = new ArrayList<>();
      int counter = 0;
      for (int j = matrix[0].length - 2 - k; j > k; j--) {
         if (counter == numberOfNeededItems) {
            return res;
         }
         res.add(matrix[matrix.length - 1 - k][j]);
         counter++;
      }
      return res;
   }

   private static List<Integer> getFirstColumn(int[][] matrix, int k, int numberOfNeededItems) {
      List<Integer> res = new ArrayList<>();
      int counter = 0;
      for (int i = matrix.length - 1 - k; i > k; i--) {
         if (counter == numberOfNeededItems) {
            return res;
         }
         res.add(matrix[i][k]);
         counter++;
      }
      return res;
   }
}
