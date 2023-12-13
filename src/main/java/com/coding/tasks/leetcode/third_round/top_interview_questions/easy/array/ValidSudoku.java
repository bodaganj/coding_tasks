package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

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
//      System.out.println(isValidSudoku(array2));
   }

   private static boolean isValidSudoku(char[][] board) {
      return validColumns(board) && validRows(board) && validRectangles(board);
   }

   private static boolean validRows(char[][] board) {
      for (char[] chars : board) {
         Set<Character> set = new HashSet<>();
         for (int j = 0; j < board.length; j++) {
            if (chars[j] != '.') {
               if (set.contains(chars[j])) {
                  return false;
               } else {
                  set.add(chars[j]);
               }
            }
         }
      }
      return true;
   }

   private static boolean validColumns(char[][] board) {
      for (int i = 0; i < board.length; i++) {
         Set<Character> set = new HashSet<>();
         for (char[] chars : board) {
            if (chars[i] != '.') {
               if (set.contains(chars[i])) {
                  return false;
               } else {
                  set.add(chars[i]);
               }
            }
         }
      }
      return true;
   }

   private static boolean validRectangles(char[][] board) {
      return isValidSquare(board, new int[]{0, 0}, new int[]{2, 2})
         && isValidSquare(board, new int[]{3, 0}, new int[]{5, 2})
         && isValidSquare(board, new int[]{6, 0}, new int[]{8, 2})
         && isValidSquare(board, new int[]{0, 3}, new int[]{2, 5})
         && isValidSquare(board, new int[]{3, 3}, new int[]{5, 5})
         && isValidSquare(board, new int[]{6, 3}, new int[]{8, 5})
         && isValidSquare(board, new int[]{0, 6}, new int[]{2, 8})
         && isValidSquare(board, new int[]{3, 6}, new int[]{5, 8})
         && isValidSquare(board, new int[]{6, 6}, new int[]{8, 8});
   }

   private static boolean isValidSquare(char[][] board, int[] topLeft, int[] bottomRight) {
      Set<Character> set = new HashSet<>();
      for (int i = topLeft[0]; i <= bottomRight[0]; i++) {
         for (int j = topLeft[1]; j <= bottomRight[1]; j++) {
            if (board[i][j] != '.') {
               if (set.contains(board[i][j])) {
                  return false;
               } else {
                  set.add(board[i][j]);
               }
            }
         }
      }
      return true;
   }
}
