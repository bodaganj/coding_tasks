package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oath", "pea", "eat", "rain"}));

      System.out.println(findWords(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}},
                                   new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"}));
   }

   private static List<String> findWords(char[][] board, String[] words) {
      // get mapping of all chars within matrix
      Map<Character, Integer> boardMapping = getBoardMapping(board);
      Map<Character, List<List<Integer>>> startingPointsOfAllChars = getStartingPointsOfAllChars(board);

      // get mapping of all chars for each word.
      // If at least one char is missing (or not enough amount of those char, skip finding this word)
      List<String> ans = new ArrayList<>();
      for (String word : words) {
         Map<Character, Integer> wordMapping = getWordMapping(word);
         if (isPotentiallyPresent(wordMapping, boardMapping)) {
            for (List<Integer> coordinates : startingPointsOfAllChars.get(word.charAt(0))) {
               Set<List<Integer>> visited = new HashSet<>();
               visited.add(coordinates);
               if (dfs(coordinates, board, word, 1, visited)) {
                  ans.add(word);
                  break;
               }
            }
         }
      }

      // go dfs for this word
      return ans;
   }

   private static boolean dfs(List<Integer> coordinates, char[][] board, String word, int index, Set<List<Integer>> visited) {
      if (index == word.length()) {
         return true;
      }

      for (int[] dir : dirs) {
         int i = coordinates.get(0) + dir[0];
         int j = coordinates.get(1) + dir[1];

         if (i >= 0 && i < board.length && j >= 0 && j < board[0].length &&
            !visited.contains(List.of(i, j)) && board[i][j] == word.charAt(index)) {

            visited.add(List.of(i, j));
            boolean flag = dfs(List.of(i, j), board, word, index + 1, visited);

            if (flag) {
               return true;
            } else {
               visited.remove(List.of(i, j));
            }
         }
      }

      return false;
   }

   private static Map<Character, Integer> getBoardMapping(char[][] board) {
      Map<Character, Integer> total = new HashMap<>();
      for (char[] chars : board) {
         for (int j = 0; j < board[0].length; j++) {
            char current = chars[j];
            total.put(current, total.getOrDefault(current, 0) + 1);
         }
      }
      return total;
   }

   private static Map<Character, Integer> getWordMapping(String word) {
      Map<Character, Integer> total = new HashMap<>();
      for (int i = 0; i < word.length(); i++) {
         char currentChar = word.charAt(i);
         total.put(currentChar, total.getOrDefault(currentChar, 0) + 1);
      }
      return total;
   }

   private static boolean isPotentiallyPresent(Map<Character, Integer> wordMapping, Map<Character, Integer> boardMapping) {
      for (Map.Entry<Character, Integer> entry : wordMapping.entrySet()) {
         if (!boardMapping.containsKey(entry.getKey()) || boardMapping.get(entry.getKey()) < entry.getValue()) {
            return false;
         }
      }
      return true;
   }

   private static Map<Character, List<List<Integer>>> getStartingPointsOfAllChars(char[][] board) {
      Map<Character, List<List<Integer>>> total = new HashMap<>();
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            char current = board[i][j];
            List<List<Integer>> lists;
            if (total.containsKey(current)) {
               lists = total.get(current);
            } else {
               lists = new ArrayList<>();
            }
            lists.add(List.of(i, j));
            total.put(current, lists);
         }
      }
      return total;
   }
}
