package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.others;

import java.util.Stack;

public class EvaluateReversePolishNotation {

   public static void main(String[] args) {
      System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
      System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
   }

   private static int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      for (String token : tokens) {
         if (token.length() > 1 || Character.isDigit(token.charAt(0))) {
            stack.push(Integer.parseInt(token));
         } else {
            int second = stack.pop();
            int first = stack.pop();
            switch (token) {
               case "*":
                  stack.push(first * second);
                  break;
               case "/":
                  stack.push(first / second);
                  break;
               case "-":
                  stack.push(first - second);
                  break;
               default:
                  stack.push(first + second);
                  break;
            }
         }
      }

      return stack.pop();
   }
}
