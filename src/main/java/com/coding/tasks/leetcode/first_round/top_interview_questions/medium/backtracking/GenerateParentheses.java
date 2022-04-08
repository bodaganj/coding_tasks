package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

   public static void main(String[] args) {
      System.out.println(generateParenthesis(2));
      System.out.println(generateParenthesis(3));
   }

   private static List<String> generateParenthesis(int n) {
      if (n == 0) {
         return Collections.emptyList();
      }

      List<String> list = new ArrayList<>();
      rec("", 0, 0, n, list);

      return list;
   }

   private static void rec(String current, int amountOfOpen, int amountOfClose, int expectedAmount, List<String> list) {
      if (amountOfOpen == amountOfClose && amountOfClose == expectedAmount) {
         list.add(current);
         return;
      }

      if (amountOfOpen < expectedAmount) {
         rec(current + "(", amountOfOpen + 1, amountOfClose, expectedAmount, list);
      }
      if (amountOfOpen > amountOfClose && amountOfClose < expectedAmount) {
         rec(current + ")", amountOfOpen, amountOfClose + 1, expectedAmount, list);
      }
   }
}
