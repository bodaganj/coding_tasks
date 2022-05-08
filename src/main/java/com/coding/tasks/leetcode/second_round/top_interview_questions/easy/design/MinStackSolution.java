package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.design;

import java.util.Stack;

public class MinStackSolution {

   public static void main(String[] args) {
      MinStack o = new MinStack(); // -
      o.push(2147483646);     // -
      o.push(2147483646);     // -
      o.push(2147483647);     // -
      o.top();                    // 2147483647
      o.pop();                   // -
      o.getMin();                // 2147483646
      o.pop();                   // -
      o.getMin();                // 2147483646
      o.pop();                   // -
      o.push(2147483647);     // -
      o.top();                   // 2147483647
      o.getMin();                // 2147483646
      o.push(-2147483648);    // -
      o.top();                   // -2147483648
      o.getMin();                // -2147483648
      o.pop();                   // -
      o.getMin();                // 2147483646
   }

   static class MinStack {

      private Stack<int[]> stack;

      public MinStack() {
         this.stack = new Stack<>();
      }

      public void push(int val) {
         if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
         } else {
            stack.push(new int[]{val, Math.min(stack.peek()[1], val)});
         }
      }

      public void pop() {
         stack.pop();
      }

      public int top() {
         return stack.peek()[0];
      }

      public int getMin() {
         return stack.peek()[1];
      }
   }
}
