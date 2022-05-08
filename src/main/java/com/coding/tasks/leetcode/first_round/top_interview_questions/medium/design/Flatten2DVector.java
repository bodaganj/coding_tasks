package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.design;

import java.util.NoSuchElementException;

public class Flatten2DVector {

   public static void main(String[] args) {
      Vector2D ve = new Vector2D(new int[0][0]);
      System.out.println(ve.hasNext());
   }

   /**
    * Your Vector2D object will be instantiated and called as such:
    * Vector2D obj = new Vector2D(vec);
    * int param_1 = obj.next();
    * boolean param_2 = obj.hasNext();
    */
   static class Vector2D {

      private int[][] vector;
      private int i = 0;
      private int j = 0;

      public Vector2D(int[][] v) {
         vector = v;
      }

      public int next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         return vector[i][j++];
      }

      public boolean hasNext() {
         advanceToNext();
         return i < vector.length;
      }

      // If the current outer and inner point to an integer, this method does nothing.
      // Otherwise, inner and outer are advanced until they point to an integer.
      // If there are no more integers, then outer will be equal to vector.length
      // when this method terminates.
      private void advanceToNext() {
         // While outer is still within the vector, but inner is over the
         // end of the inner list pointed to by outer, we want to move
         // forward to the start of the next inner vector.
         while (i < vector.length && j == vector[i].length) {
            j = 0;
            i++;
         }
      }
   }
}
