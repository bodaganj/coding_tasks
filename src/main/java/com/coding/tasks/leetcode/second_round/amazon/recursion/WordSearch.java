package com.coding.tasks.leetcode.second_round.amazon.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(exist(new char[][]{
         {'A', 'B', 'C', 'E'},
         {'S', 'F', 'C', 'S'},
         {'A', 'D', 'E', 'E'}
      }, "ABCCED"));

      System.out.println(exist(new char[][]{
         {'A', 'B', 'C', 'E'},
         {'S', 'F', 'C', 'S'},
         {'A', 'D', 'E', 'E'}
      }, "ABCB"));

      System.out.println(exist(new char[][]{
         {'C', 'A', 'A'},
         {'A', 'A', 'A'},
         {'B', 'C', 'D'}
      }, "AAB"));
   }

   private static boolean exist(char[][] board, String word) {
      if (board.length * board[0].length < word.length()) {
         return false;
      }

      Map<Character, List<List<Integer>>> boardMapping = getBoardMapping(board);
      Map<Character, Integer> wordMapping = getWordMapping(word);
      for (Map.Entry<Character, Integer> entry : wordMapping.entrySet()) {
         if (!boardMapping.containsKey(entry.getKey()) || boardMapping.get(entry.getKey()).size() < entry.getValue()) {
            return false;
         }
      }

      for (List<Integer> list : boardMapping.get(word.charAt(0))) {
         Set<List<Integer>> visited = new HashSet<>();
         visited.add(list);
         if (dfs(list, 1, word, board, visited)) {
            return true;
         }
         visited.remove(list);
      }
      return false;
   }

   private static boolean dfs(List<Integer> coordinates, int index, String word, char[][] board, Set<List<Integer>> visited) {
      if (index == word.length()) {
         return true;
      } else {
         for (int[] dir : dirs) {
            int i = coordinates.get(0) + dir[0];
            int j = coordinates.get(1) + dir[1];
            List<Integer> newCoordinates = List.of(i, j);

            if (i >= 0 && i < board.length && j < board[0].length && j >= 0 && !visited.contains(newCoordinates)
               && board[i][j] == word.charAt(index)) {
               visited.add(newCoordinates);
               boolean flag = dfs(newCoordinates, index + 1, word, board, visited);
               if (flag) {
                  return true;
               } else {
                  visited.remove(newCoordinates);
               }
            }
         }
      }
      return false;
   }

   private static Map<Character, List<List<Integer>>> getBoardMapping(char[][] board) {
      Map<Character, List<List<Integer>>> mapping = new HashMap<>();
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            char curr = board[i][j];
            List<List<Integer>> lists;
            if (mapping.containsKey(curr)) {
               lists = mapping.get(curr);
            } else {
               lists = new ArrayList<>();
            }
            lists.add(List.of(i, j));
            mapping.put(curr, lists);
         }
      }
      return mapping;
   }

   private static Map<Character, Integer> getWordMapping(String word) {
      Map<Character, Integer> mapping = new HashMap<>();
      for (char aChar : word.toCharArray()) {
         mapping.put(aChar, mapping.getOrDefault(aChar, 0) + 1);
      }
      return mapping;
   }
}
