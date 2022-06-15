package com.coding.tasks.other;

public class Crossword {

   public static void main(String[] args) {
      System.out.println(placeWordInCrossword(new char[][]{
         {'#', ' ', '#'},
         {'#', ' ', '#'},
         {'#', ' ', 'c'}
      }, "ca"));
   }

   private static boolean placeWordInCrossword(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if ((j == 0 || board[i][j - 1] == '#') && (board[i][j] == ' ' || board[i][j] == word.charAt(0))) {
               boolean flag = canGoHorizontallyToRight(board, word.substring(1), i, j + 1);
               if (flag) {
                  return true;
               }
            }
            if ((j == board[0].length - 1 || board[i][j + 1] == '#') && (board[i][j] == ' ' || board[i][j] == word.charAt(0))) {
               boolean flag = canGoHorizontallyToLeft(board, word.substring(1), i, j - 1);
               if (flag) {
                  return true;
               }
            }

            if ((i == 0 || board[i - 1][j] == '#') && (board[i][j] == ' ' || board[i][j] == word.charAt(0))) {
               boolean flag = canGoVerticallyBottom(board, word.substring(1), i + 1, j);
               if (flag) {
                  return true;
               }
            }
            if ((i == board.length - 1 || board[i + 1][j] == '#') && (board[i][j] == ' ' || board[i][j] == word.charAt(0))) {
               boolean flag = canGoVerticallyTop(board, word.substring(1), i - 1, j);
               if (flag) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private static boolean canGoHorizontallyToRight(char[][] board, String word, int x, int y) {
      if (word.isEmpty() && y < board[0].length && board[x][y] != '#') {
         return false;
      }
      if (word.isEmpty() && (y >= board[0].length || board[x][y] == '#')) {
         return true;
      }
      if (y >= board[0].length || board[x][y] == '#' || (board[x][y] != ' ' && board[x][y] != word.charAt(0))) {
         return false;
      }
      return canGoHorizontallyToRight(board, word.substring(1), x, y + 1);
   }

   private static boolean canGoHorizontallyToLeft(char[][] board, String word, int x, int y) {
      if (word.isEmpty() && y >= 0 && board[x][y] != '#') {
         return false;
      }
      if (word.isEmpty() && (y < 0 || board[x][y] == '#')) {
         return true;
      }
      if (y < 0 || board[x][y] == '#' || (board[x][y] != ' ' && board[x][y] != word.charAt(0))) {
         return false;
      }
      return canGoHorizontallyToLeft(board, word.substring(1), x, y - 1);
   }

   private static boolean canGoVerticallyBottom(char[][] board, String word, int x, int y) {
      if (word.isEmpty() && x < board.length && board[x][y] != '#') {
         return false;
      }
      if (word.isEmpty() && (x >= board.length || board[x][y] == '#')) {
         return true;
      }
      if (x >= board.length || board[x][y] == '#' || (board[x][y] != ' ' && board[x][y] != word.charAt(0))) {
         return false;
      }
      return canGoVerticallyBottom(board, word.substring(1), x + 1, y);
   }

   private static boolean canGoVerticallyTop(char[][] board, String word, int x, int y) {
      if (word.isEmpty() && x >= 0 && board[x][y] != '#') {
         return false;
      }
      if (word.isEmpty() && (x < 0 || board[x][y] == '#')) {
         return true;
      }
      if (x < 0 || board[x][y] == '#' || (board[x][y] != ' ' && board[x][y] != word.charAt(0))) {
         return false;
      }
      return canGoVerticallyTop(board, word.substring(1), x - 1, y);
   }
}
