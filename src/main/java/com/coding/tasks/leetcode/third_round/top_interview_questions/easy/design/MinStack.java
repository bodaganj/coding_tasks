package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.design;

import java.util.Stack;

public class MinStack {

   private final Stack<Pair> stack;

   public MinStack() {
      this.stack = new Stack<>();
   }

   public static void main(String[] args) {
      MinStack minStack = new MinStack();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      minStack.getMin();
      minStack.pop();
      minStack.top();
      minStack.getMin();
   }

   public void push(int val) {
      if (stack.isEmpty()) {
         stack.push(new Pair(val, val));
      } else {
         stack.push(new Pair(val, Math.min(stack.peek().min, val)));
      }
   }

   public void pop() {
      stack.pop();
   }

   public int top() {
      return stack.peek().val;
   }

   public int getMin() {
      return stack.peek().min;
   }

   record Pair(int val, int min) {

   }
}
