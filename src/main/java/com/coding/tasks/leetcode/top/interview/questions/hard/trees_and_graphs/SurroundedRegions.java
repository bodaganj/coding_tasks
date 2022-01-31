package com.coding.tasks.leetcode.top.interview.questions.hard.trees_and_graphs;

import java.util.Arrays;

public class SurroundedRegions {

   public static void main(String[] args) {
      char[][] arr1 = new char[][]{
         {'X', 'X', 'X', 'X'},
         {'X', 'O', 'O', 'X'},
         {'X', 'X', 'O', 'X'},
         {'X', 'O', 'X', 'X'}
      };

      char[][] arr2 = new char[][]{
         {'O', 'X', 'X', 'O', 'X'},
         {'X', 'O', 'O', 'X', 'O'},
         {'X', 'O', 'X', 'O', 'X'},
         {'O', 'X', 'O', 'O', 'O'},
         {'X', 'X', 'O', 'X', 'O'}
      };

      solve(arr1);
      solve(arr2);

      System.out.println(Arrays.deepToString(arr1));
      System.out.println(Arrays.deepToString(arr2));
   }

   private static void solve(char[][] board) {

   }
}
