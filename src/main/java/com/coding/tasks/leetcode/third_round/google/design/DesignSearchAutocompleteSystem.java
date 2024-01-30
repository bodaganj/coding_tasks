package com.coding.tasks.leetcode.third_round.google.design;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class DesignSearchAutocompleteSystem {

   public static void main(String[] args) {
      AutocompleteSystem autocompleteSystem = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                                                                     new int[]{5, 3, 2, 2});
      autocompleteSystem.input('i');
      autocompleteSystem.input(' ');
      autocompleteSystem.input('a');
      autocompleteSystem.input('#');
      //      [["i love you","island","i love leetcode"],["i love you","i love leetcode"],[],[]]
      System.out.println("*************");
      autocompleteSystem.input('i');
      autocompleteSystem.input(' ');
      autocompleteSystem.input('a');
      autocompleteSystem.input('#');
      //      ["i love you","island","i love leetcode"],["i love you","i love leetcode","i a"],["i a"],[]
      System.out.println("*************");
      autocompleteSystem.input('i');
      autocompleteSystem.input(' ');
      autocompleteSystem.input('a');
      autocompleteSystem.input('#');

      //       ["i love you","island","i a"],["i love you","i a","i love leetcode"],["i a"],[]]
   }

   static class AutocompleteSystem {

      private final TreeNode root;
      private StringBuilder sb;
      private TreeNode currentNode;

      public AutocompleteSystem(String[] sentences, int[] times) {
         root = new TreeNode();
         currentNode = root;
         sb = new StringBuilder();
         for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            saveSentence(sentence, times[i]);
         }
      }

      public List<String> input(char c) {
         if (c == '#') {
            saveSentence(sb.toString(), 1);
            sb = new StringBuilder();
            currentNode = root;
            return List.of();
         } else {
            sb.append(c);
            if (currentNode.children.containsKey(c)) {
               TreeNode treeNode = currentNode.children.get(c);
               currentNode = treeNode;
               LinkedList<String> ans = new LinkedList<>();
               Queue<String> hot = treeNode.hotStrings;
               while (!hot.isEmpty()) {
                  ans.addFirst(hot.poll());
               }

               treeNode.hotStrings.addAll(ans);
               System.out.println("------");
               for (String an : ans) {
                  System.out.println(an + " -> " + currentNode.stringsCounter.get(an));
               }
               System.out.println("------");

               return ans;
            } else {
               return Collections.emptyList();
            }
         }
      }

      private void saveSentence(String sentence, int counter) {
         TreeNode node = root;
         for (char curr : sentence.toCharArray()) {
            if (node.children.containsKey(curr)) {
               TreeNode treeNode = node.children.get(curr);

               // increase counter for current sentence
               int count = 0;
               if (treeNode.stringsCounter.containsKey(sentence)) {
                  count = treeNode.stringsCounter.get(sentence);
               }
               count += counter;
               treeNode.stringsCounter.put(sentence, count);

               // update hot strings list
               treeNode.hotStrings.add(sentence);
               if (treeNode.hotStrings.size() == 4) {
                  treeNode.hotStrings.poll();
               }

               // move to next char within the sentence
               node = treeNode;
            } else {
               // add current char to children
               TreeNode newNode = new TreeNode();

               // add current string to all hot strings
               newNode.stringsCounter.put(sentence, counter);

               // update hot strings list
               newNode.hotStrings.add(sentence);
               if (newNode.hotStrings.size() == 4) {
                  newNode.hotStrings.poll();
               }

               node.children.put(curr, newNode);
               node = newNode;
            }
         }
      }

      private class TreeNode {

         private final Map<Character, TreeNode> children;
         private final Map<String, Integer> stringsCounter;
         private final Queue<String> hotStrings;

         public TreeNode() {
            this.children = new HashMap<>();
            this.stringsCounter = new HashMap<>();
            this.hotStrings = new PriorityQueue<>((o1, o2) -> {
               if (!Objects.equals(stringsCounter.get(o1), stringsCounter.get(o2))) {
                  return stringsCounter.get(o1) - stringsCounter.get(o2);
               } else {
                  return o2.compareTo(o1);
               }
            });
         }
      }
   }
}
