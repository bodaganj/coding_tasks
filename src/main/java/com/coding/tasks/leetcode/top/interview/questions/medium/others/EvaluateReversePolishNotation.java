package com.coding.tasks.leetcode.top.interview.questions.medium.others;

import java.util.Stack;

public class EvaluateReversePolishNotation {

   public static void main(String[] args) {
      System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
   }

   private static int evalRPN(String[] tokens) {
      Stack<String> stack = new Stack<>();

      for (String token : tokens) {
         switch (token) {
            case "+": {
               int second = Integer.parseInt(stack.pop());
               int first = Integer.parseInt(stack.pop());
               stack.add(first + second + "");
               break;
            }
            case "-": {
               int second = Integer.parseInt(stack.pop());
               int first = Integer.parseInt(stack.pop());
               stack.add(first - second + "");
               break;
            }
            case "*": {
               int second = Integer.parseInt(stack.pop());
               int first = Integer.parseInt(stack.pop());
               stack.add(first * second + "");
               break;
            }
            case "/": {
               int second = Integer.parseInt(stack.pop());
               int first = Integer.parseInt(stack.pop());
               stack.add(first / second + "");
               break;
            }
            default:
               stack.add(token);
               break;
         }
      }

      return Integer.parseInt(stack.pop());
   }
}
