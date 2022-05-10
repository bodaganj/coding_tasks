package com.coding.tasks.leetcode.second_round.google.design;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
    * HashMap implementation
    */
   static class AutocompleteSystem {

      private final TreeNode root;
      private StringBuilder sb;
      private TreeNode current;

      public AutocompleteSystem(String[] sentences, int[] times) {
         this.sb = new StringBuilder();

         this.root = new TreeNode();
         for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            TreeNode tmp = root;

            for (char aChar : sentence.toCharArray()) {
               if (tmp.map.containsKey(aChar)) {
                  tmp = tmp.map.get(aChar);
               } else {
                  TreeNode tmpNode = new TreeNode();
                  tmp.map.put(aChar, tmpNode);
                  tmp = tmpNode;
               }
            }
            tmp.sentences.put(sentence, times[i]);
            tmp.isSentence = true;
         }

         this.current = root;
      }

      public List<String> input(char c) {
         if (c == '#') {
            this.current.isSentence = true;

            String sentence = sb.toString();
            if (this.current.sentences.containsKey(sentence)) {
               this.current.sentences.put(sentence, this.current.sentences.get(sentence) + 1);
            } else {
               this.current.sentences.put(sentence, 1);
            }

            this.sb = new StringBuilder();
            this.current = root;
            return Collections.emptyList();
         } else {
            sb.append(c);
            if (current.map.containsKey(c)) {
               current = current.map.get(c);

               // find all sentences
               Map<String, Integer> allSentences = new HashMap<>();
               Queue<TreeNode> queue = new LinkedList<>();
               TreeNode queueNode = current;
               queue.offer(queueNode);
               while (!queue.isEmpty()) {
                  int size = queue.size();
                  while (size-- > 0) {
                     TreeNode poll = queue.poll();
                     if (poll.isSentence) {
                        allSentences.putAll(poll.sentences);
                     }
                     for (Map.Entry<Character, TreeNode> entry : poll.map.entrySet()) {
                        queue.offer(entry.getValue());
                     }
                  }
               }

               Comparator<Map.Entry<String, Integer>> timesComparator = Map.Entry.comparingByValue();
               Comparator<Map.Entry<String, Integer>> sentenceComparator = Map.Entry.comparingByKey();

               return allSentences.entrySet()
                                  .stream()
                                  .sorted(timesComparator.reversed().thenComparing(sentenceComparator))
                                  .limit(3)
                                  .map(Map.Entry::getKey)
                                  .collect(Collectors.toList());
            } else {
               TreeNode newNode = new TreeNode();
               current.map.put(c, newNode);
               current = newNode;
               return Collections.emptyList();
            }
         }
      }

      static class TreeNode {

         public Map<Character, TreeNode> map;
         public Map<String, Integer> sentences;
         public boolean isSentence = false;

         public TreeNode() {
            this.map = new HashMap<>();
            this.sentences = new HashMap<>();
         }
      }
   }
}
