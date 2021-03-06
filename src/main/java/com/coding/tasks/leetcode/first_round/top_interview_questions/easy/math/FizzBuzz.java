package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

   public static void main(String[] args) {

   }

   private static List<String> fizzBuzz(int n) {
      List<String> list = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
         if (i % 3 == 0 && i % 5 == 0) {
            list.add("FizzBuzz");
         } else if (i % 3 == 0) {
            list.add("Fizz");
         } else if (i % 5 == 0) {
            list.add("Buzz");
         } else {
            list.add(i + "");
         }
      }
      return list;
   }
}
