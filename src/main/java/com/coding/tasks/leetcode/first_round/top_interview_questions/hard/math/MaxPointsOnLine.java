package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPointsOnLine {

   public static void main(String[] args) {
      System.out.println(maxPoints(new int[][]{
         {1, 1},
         {3, 2},
         {5, 3},
         {4, 1},
         {2, 3},
         {1, 4}
      }));

      System.out.println(maxPoints(new int[][]{
         {1, 1},
         {2, 2},
         {3, 3}
      }));
   }

   private static int maxPoints(int[][] points) {
      List<Integer> list = new ArrayList<>();
      list.add(getFirstDiagonal(points));
      list.add(getSecondDiagonal(points));
      list.add(getHorizontal(points));
      list.add(getVertical(points));

      if (points.length > 1) {
         list.add(2);
      }
      return Collections.max(list);
   }

   private static int getFirstDiagonal(int[][] points) {
      List<Integer> list = new ArrayList<>();

      for (int[] point : points) {
         list.add(Math.abs(point[0] + point[1]));
      }

      Map<Integer, Integer> map = new HashMap<>();
      for (Integer integer : list) {
         map.put(integer, map.getOrDefault(integer, 0) + 1);
      }

      int max = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         max = Math.max(max, entry.getValue());
      }

      return max;
   }

   private static int getSecondDiagonal(int[][] points) {
      List<Integer> list = new ArrayList<>();

      for (int[] point : points) {
         list.add(Math.abs(point[0] - point[1]));
      }

      Map<Integer, Integer> map = new HashMap<>();
      for (Integer integer : list) {
         map.put(integer, map.getOrDefault(integer, 0) + 1);
      }

      int max = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         max = Math.max(max, entry.getValue());
      }

      return max;
   }

   private static int getHorizontal(int[][] points) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int[] point : points) {
         map.put(point[0], map.getOrDefault(point[0], 0) + 1);
      }

      int max = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         max = Math.max(max, entry.getValue());
      }

      return max;
   }

   private static int getVertical(int[][] points) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int[] point : points) {
         map.put(point[1], map.getOrDefault(point[1], 0) + 1);
      }

      int max = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         max = Math.max(max, entry.getValue());
      }

      return max;
   }
}
