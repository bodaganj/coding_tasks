package com.coding.tasks.leetcode.first_round.google.design;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DesignSearchAutocompleteSystem {

   public static void main(String[] args) {
      DesignSearchAutocompleteSystem.AutocompleteSystem o =
         new DesignSearchAutocompleteSystem.AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                                                               new int[]{5, 3, 2, 2});
      System.out.println(o.input('i'));
      System.out.println(o.input(' '));
      System.out.println(o.input('a'));
      System.out.println(o.input('#'));
   }

   /**
    * Trie implementation
    */
//   static class AutocompleteSystem {
//
//      public StringBuilder sb;
//      public Trie trie;
//
//      public AutocompleteSystem(String[] sentences, int[] times) {
//         sb = new StringBuilder();
//         trie = new Trie();
//
//         // fill in the trie with initial data
//         for (int i = 0; i < sentences.length; i++) {
//            trie.addSentence(sentences[i], times[i]);
//         }
//      }
//
//      public List<String> input(char c) {
//         if (c == '#') {
//            String str = sb.toString();
//            sb = new StringBuilder();
//
//            trie.addSentence(str, 1);
//            return Collections.emptyList();
//         } else {
//            sb.append(c);
//            return trie.getPotentialSentencesByPrefix(sb.toString());
//         }
//      }
//   }
//
//   static class Trie {
//
//      public TreeNode root;
//
//      public Trie() {
//         root = new TreeNode(' ');
//      }
//
//      // Add sentence and hot ranking to current trie (initial value of hot + hot)
//      public void addSentence(String sentence, int hot) {
//         TreeNode node = root;
//
//         int i = 0;
//         while (i < sentence.length()) {
//            char aChar = sentence.charAt(i);
//
//            if (node.children.containsKey(aChar)) {
//               node = node.children.get(aChar);
//            } else {
//               TreeNode tmp = new TreeNode(aChar);
//               node.children.put(aChar, tmp);
//               node = tmp;
//            }
//
//            if (i == sentence.length() - 1) {
//               node.isWord = true;
//               node.hot += hot;
//            }
//
//            i++;
//         }
//      }
//
//      // Is prefix present
//      public List<String> getPotentialSentencesByPrefix(String prefix) {
//         TreeNode node = root;
//         List<String> ans = new ArrayList<>();
//
//         int i = 0;
//         while (i < prefix.length()) {
//            char charAt = prefix.charAt(i);
//            if (node.children.containsKey(charAt)) {
//               node = node.children.get(charAt);
//               i++;
//
//               if (i == prefix.length()) {
//                  StringBuilder sb = new StringBuilder(prefix);
//                  getAllSentences(node, sb, ans);
//               }
//            } else {
//               return Collections.emptyList();
//            }
//         }
//
//
//
//
//         return ans;
//      }
//
//      private void getAllSentences(TreeNode node, StringBuilder sb, List<String> ans) {
//         sb.append(node.val);
//         if (node.children.isEmpty()) {
//            ans.add(sb.toString());
//         } else {
//            if (node.isWord) {
//               ans.add(sb.toString());
//            }
//            for (TreeNode value : node.children.values()) {
//               getAllSentences(value, sb, ans);
//            }
//         }
//      }
//   }
//
//   static class TreeNode {
//
//      public char val;
//      public Map<Character, TreeNode> children;
//      public boolean isWord;
//      public int hot;
//
//      public TreeNode(char val) {
//         this.val = val;
//         this.children = new HashMap<>();
//         this.isWord = false;
//      }
//   }

   /**
    * HashMap implementation
    */
   static class AutocompleteSystem {

      private Map<String, Integer> senToTimeMapping;
      private StringBuilder sb = new StringBuilder();

      public AutocompleteSystem(String[] sentences, int[] times) {
         senToTimeMapping = new HashMap<>();

         for (int i = 0; i < sentences.length; i++) {
            senToTimeMapping.put(sentences[i], times[i]);
         }
      }

      public List<String> input(char c) {
         if (c == '#') {
            String string = sb.toString();
            senToTimeMapping.put(string, senToTimeMapping.getOrDefault(string, 0) + 1);
            sb = new StringBuilder();
            return Collections.emptyList();
         } else {
            sb.append(c);
            return senToTimeMapping.entrySet().stream()
                                   .filter(entry -> entry.getKey().startsWith(sb.toString()))
                                   .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().thenComparing(Map.Entry::getKey))
                                   .limit(3)
                                   .map(Map.Entry::getKey)
                                   .collect(Collectors.toList());
         }
      }
   }
}
