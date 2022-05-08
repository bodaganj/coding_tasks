package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.design;

import java.util.LinkedList;

public class Flatten2DVector {

   public static void main(String[] args) {
      Vector2D ve = new Vector2D(new int[0][0]);
      System.out.println(ve.hasNext());
   }

   static class Vector2D {

      private LinkedList<Integer> list;

      public Vector2D(int[][] vec) {
         list = new LinkedList<>();
         for (int[] ints : vec) {
            for (int anInt : ints) {
               list.add(anInt);
            }
         }
      }

      public int next() {
         int tmp = list.getFirst();
         list.removeFirst();
         return tmp;
      }

      public boolean hasNext() {
         return !list.isEmpty();
      }
   }
}
