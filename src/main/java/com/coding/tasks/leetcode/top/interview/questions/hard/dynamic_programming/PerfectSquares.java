package com.coding.tasks.leetcode.top.interview.questions.hard.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

   private static int min;

   public static void main(String[] args) {
      System.out.println(numSquares(1));
      System.out.println(numSquares(34));
      System.out.println(numSquares(32));
      System.out.println(numSquares(35));
   }

   private static int numSquares(int n) {
      min = Integer.MAX_VALUE;
      // get set of all perfect square numbers up to n
      List<Integer> listOfNumbers = getListOfNumbers(n);

      // starting from the last element of set check if set contains (n - element) until it is 0
      for (int i = listOfNumbers.size() - 1; i >= 0; i--) {
         rec(i, listOfNumbers, n, 0);
      }

      return min;
   }

   private static void rec(int index, List<Integer> listOfNumbers, int number, int currentAmountOfNumbers) {
      if (number == 0) {
         min = Math.min(min, currentAmountOfNumbers);
         return;
      }

      if (currentAmountOfNumbers > min) {
         return;
      }

      for (int i = index; i >= 0; i--) {
         if (listOfNumbers.get(i) <= number) {
            rec(index, listOfNumbers, number - listOfNumbers.get(i), currentAmountOfNumbers + 1);
         }
      }
   }

   private static List<Integer> getListOfNumbers(int n) {
      List<Integer> list = new ArrayList<>();
      int i = 1;
      while (true) {
         int squareNumber = i * i;
         if (squareNumber <= n) {
            list.add(squareNumber);
         } else {
            break;
         }
         i++;
      }
      return list;
   }
}
