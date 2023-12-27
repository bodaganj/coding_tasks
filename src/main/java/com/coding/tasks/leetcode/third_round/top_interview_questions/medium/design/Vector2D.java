package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.design;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Vector2D {

   private final Queue<int[]> queue;
   private int index;

   public Vector2D(int[][] vec) {
      queue = new LinkedList<>();
      Collections.addAll(queue, vec);
      index = 0;
   }

   public int next() {
      if (hasNext()) {
         return queue.peek()[index++];
      } else {
         throw new RuntimeException("No elements");
      }
   }

   public boolean hasNext() {
      int[] peek = queue.peek();
      if (queue.isEmpty()) {
         return false;
      }

      if (index < peek.length) {
         return true;
      }

      if (index == peek.length) {
         queue.poll();
         index = 0;
      }
      return hasNext();
   }
}
