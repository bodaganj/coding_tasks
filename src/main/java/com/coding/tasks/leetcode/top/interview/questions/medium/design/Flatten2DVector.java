package com.coding.tasks.leetcode.top.interview.questions.medium.design;

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

      private int[][] vec;
      private int i;
      private int j;

      public Vector2D(int[][] vec) {
         this.vec = vec;
         this.i = 0;
         this.j = 0;
      }

      public int next() {
         int ans = this.vec[i][j];
         if (j + 1 < vec[i].length) {
            j++;
         } else {
            i++;
            j = 0;
         }
         return ans;
      }

      public boolean hasNext() {
         return vec != null && vec.length != 0 && i < vec.length;
      }
   }
}
