package com.coding.tasks.leetcode.first_round.amazon.design;

import java.util.Stack;

public class MinStackTask {

   /**
    * Your MinStack object will be instantiated and called as such:
    * MinStack obj = new MinStack();
    * obj.push(val);
    * obj.pop();
    * int param_3 = obj.top();
    * int param_4 = obj.getMin();
    */
   static class MinStack {

      public Stack<int[]> stack = new Stack<>();

      public MinStack() {
      }

      public void push(int val) {
         if (stack.isEmpty()) {
            stack.add(new int[]{val, val});
         } else {
            stack.add(new int[]{val, Math.min(stack.peek()[1], val)});
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
