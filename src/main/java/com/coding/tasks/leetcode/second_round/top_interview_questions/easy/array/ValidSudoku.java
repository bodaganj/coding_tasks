package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

   public static void main(String[] args) {
      char[][] array1 = new char[][]{
         {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
         {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
         {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
         {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
         {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
         {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
         {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
      };
      char[][] array2 = new char[][]{
         {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
         {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
         {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
         {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
         {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
         {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
         {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
      };
      char[][] array3 = new char[][]{
         {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
         {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
         {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
         {'.', '.', '.', '2', '.', '7', '.', '.', '.'},
         {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
         {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
         {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
      };

      System.out.println(isValidSudoku(array1));
      System.out.println(isValidSudoku(array2));
      System.out.println(isValidSudoku(array3));
   }

   private static boolean isValidSudoku(char[][] board) {
      return isValidColumns(board) && isValidRows(board) && isValidSubMatrixes(board);
   }

   private static boolean isValidRows(char[][] board) {
      for (char[] chars : board) {
         Set<Integer> set = new HashSet<>();
         for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
               if (!set.add(Integer.parseInt(aChar + ""))) {
                  return false;
               }
            }
         }
      }
      return true;
   }

   private static boolean isValidColumns(char[][] board) {
      for (int j = 0; j < board[0].length; j++) {
         Set<Integer> set = new HashSet<>();
         for (char[] chars : board) {
            if (Character.isDigit(chars[j])) {
               if (!set.add(Integer.parseInt(chars[j] + ""))) {
                  return false;
               }
            }
         }
      }
      return true;
   }

   private static boolean isValidSubMatrixes(char[][] board) {
      int range = 3;
      for (int i = 0; i < board.length; i = i + range) {
         for (int j = 0; j < board[i].length; j = j + range) {
            Set<Integer> set = new HashSet<>();
            for (int row = i; row < i + range; row++) {
               for (int col = j; col < j + range; col++) {
                  if (Character.isDigit(board[row][col])) {
                     if (!set.add(Integer.parseInt(board[row][col] + ""))) {
                        return false;
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
