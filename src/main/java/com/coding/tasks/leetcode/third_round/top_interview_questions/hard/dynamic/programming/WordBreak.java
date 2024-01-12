package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

   public static void main(String[] args) {
//      System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
//      System.out.println(wordBreak("applepenapple", List.of("apple", "pen"))); // true
//      System.out.println(wordBreak("aaa", List.of("aa", "a"))); // true
      System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aaa"))); // true
      System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
      System.out.println(wordBreak("aaa", List.of("aa"))); // false
   }

   public static boolean wordBreak(String s, List<String> wordDict) {
      boolean[] dp = new boolean[s.length()];
      Set<String> set = new HashSet<>(wordDict);

      int left = 0;
      while (left < s.length()) {
         for (int right = left + 1; right <= s.length(); right++) {
            if (left == 0 || dp[left - 1]) {
               if (set.contains(s.substring(left, right))) {
                  dp[right - 1] = true;
               }
            }
         }
         left++;
      }
      return dp[dp.length - 1];
   }

//   public static boolean wordBreak(String s, List<String> wordDict) {
//      if (!checkAllNeededLetters(s, wordDict)) {
//         return false;
//      }
//      TreeNode trie = getTrie(wordDict);
//      return find(s, trie);
//   }
//
//   private static boolean find(String s, TreeNode root) {
//      Queue<Pair> queue = new LinkedList<>();
//      queue.add(new Pair(0, root));
//      while (!queue.isEmpty()) {
//         Pair poll = queue.poll();
//         int index = poll.index;
//         TreeNode tmp = poll.node;
//
//         while (index < s.length() && tmp.children.containsKey(s.charAt(index))) {
//            TreeNode treeNode = tmp.children.get(s.charAt(index));
//            if (treeNode.isWord) {
//               if (index == s.length() - 1) {
//                  return true;
//               } else {
//                  queue.add(new Pair(index + 1, root));
//               }
//            }
//            tmp = treeNode;
//            index++;
//         }
//      }
//      return false;
//   }
//
//   private record Pair(int index, TreeNode node){}
//
//   private static TreeNode getTrie(List<String> wordDict) {
//      TreeNode root = new TreeNode();
//      for (String word : wordDict) {
//         TreeNode tmp = root;
//         for (char c : word.toCharArray()) {
//            if (tmp.children.containsKey(c)) {
//               tmp = tmp.children.get(c);
//            } else {
//               TreeNode newNode = new TreeNode();
//               tmp.children.put(c, newNode);
//               tmp = newNode;
//            }
//         }
//         tmp.isWord = true;
//      }
//      return root;
//   }
//
//   private static class TreeNode {
//
//      public Map<Character, TreeNode> children = new HashMap<>();
//      public boolean isWord;
//   }

//   public static boolean wordBreak(String s, List<String> wordDict) {
//      int maxLength = 0;
//      for (String word : wordDict) {
//         maxLength = Math.max(maxLength, word.length());
//      }
//
//      Set<String> words = new HashSet<>(wordDict);
//      if (!checkAllNeededLetters(s, wordDict)) {
//         return false;
//      }
//      return recursion(0, s, words, new HashMap<>(), maxLength);
//   }
//
//   private static boolean recursion(int index, String s, Set<String> words, Map<Pair, Boolean> memo, int maxLength) {
//      if (index == s.length()) {
//         return true;
//      } else {
//         int i = index + 1;
//         while (i <= s.length() && i - index <= maxLength) {
//            String substring = s.substring(index, i);
//            if (words.contains(substring)) {
//               Pair pair = new Pair(index, substring);
//               if (memo.containsKey(pair)) {
//                  if (memo.get(pair)) {
//                     return true;
//                  }
//               }
//               if (recursion(i, s, words, memo, maxLength)) {
//                  return true;
//               } else {
//                  memo.put(new Pair(index, substring), false);
//               }
//            }
//            i++;
//         }
//         return false;
//      }
//   }
//
//   private static boolean checkAllNeededLetters(String s, List<String> wordDict) {
//      Map<Character, Integer> sMap = new HashMap<>();
//      for (char c : s.toCharArray()) {
//         sMap.put(c, sMap.getOrDefault(c, 0) + 1);
//      }
//
//      Map<Character, Integer> wordsMap = new HashMap<>();
//      for (String word : wordDict) {
//         for (char c : word.toCharArray()) {
//            wordsMap.put(c, sMap.getOrDefault(c, 0) + 1);
//         }
//      }
//
//      for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
//         if (!wordsMap.containsKey(entry.getKey())) {
//            return false;
//         }
//      }
//
//      return true;
//   }
//
//   private record Pair(int index, String word) {
//
//   }
}
