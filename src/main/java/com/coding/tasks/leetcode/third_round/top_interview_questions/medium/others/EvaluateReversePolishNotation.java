package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.others;

import java.util.Stack;

public class EvaluateReversePolishNotation {

   public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      for (String token : tokens) {
         switch (token) {
            case "+" -> {
               Integer second = stack.pop();
               Integer first = stack.pop();
               stack.add(first + second);
            }
            case "-" -> {
               Integer second = stack.pop();
               Integer first = stack.pop();
               stack.add(first - second);
            }
            case "*" -> {
               Integer second = stack.pop();
               Integer first = stack.pop();
               stack.add(first * second);
            }
            case "/" -> {
               Integer second = stack.pop();
               Integer first = stack.pop();
               stack.add(first / second);
            }
            default -> stack.add(Integer.parseInt(token));
         }
      }
      return stack.pop();
   }
}
