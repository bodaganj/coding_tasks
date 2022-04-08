package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.array;

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

      System.out.println(isValidSudoku(array1));
      System.out.println(isValidSudoku(array2));
   }

   private static boolean isValidSudoku(char[][] board) {
      if (board == null) {
         return false;
      }
      return areValidRows(board) && areValidColumns(board) && areValidSubBoxes(board);
   }

   private static boolean areValidRows(char[][] board) {
      for (int i = 0; i < 9; i++) {
         Set<Character> set = new HashSet<>();
         for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
               continue;
            }
            if (!set.add(board[i][j])) {
               return false;
            }
         }
      }
      return true;
   }

   private static boolean areValidColumns(char[][] board) {
      for (int i = 0; i < 9; i++) {
         Set<Character> set = new HashSet<>();
         for (int j = 0; j < 9; j++) {
            if (board[j][i] == '.') {
               continue;
            }
            if (!set.add(board[j][i])) {
               return false;
            }
         }
      }
      return true;
   }

   private static boolean areValidSubBoxes(char[][] board) {
      return isValidSubBox(board, 0, 0) && isValidSubBox(board, 3, 3) && isValidSubBox(board, 6, 6)
         && isValidSubBox(board, 0, 3) && isValidSubBox(board, 0, 6) && isValidSubBox(board, 3, 6)
         && isValidSubBox(board, 3, 0) && isValidSubBox(board, 6, 0) && isValidSubBox(board, 6, 3);
   }

   private static boolean isValidSubBox(char[][] board, int row, int column) {
      Set<Character> set = new HashSet<>();
      for (int i = row; i < row + 3; i++) {
         for (int j = column; j < column + 3; j++) {
            if (board[j][i] == '.') {
               continue;
            }
            if (!set.add(board[j][i])) {
               return false;
            }
         }
      }
      return true;
   }
}
