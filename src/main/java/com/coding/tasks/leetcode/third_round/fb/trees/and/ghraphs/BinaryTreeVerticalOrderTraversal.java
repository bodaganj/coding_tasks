package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrderTraversal {

   public static void main(String[] args) {
      TreeNode tn2 = new TreeNode(2);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn7 = new TreeNode(7);
      TreeNode tn1 = new TreeNode(1, null, tn2);
      TreeNode tn0 = new TreeNode(0, tn5, null);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn8 = new TreeNode(8, tn1, tn7);
      TreeNode tn9 = new TreeNode(9, tn4, tn0);
      TreeNode tn3 = new TreeNode(3, tn9, tn8);
      System.out.println(verticalOrder(tn3));
   }

   public static List<List<Integer>> verticalOrder(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      Map<Integer, List<Pair>> map = new TreeMap<>();
      rec(root, 0, 0, map);

      return map.values()
                .stream()
                .map(list -> list.stream()
                                 .sorted(Comparator.comparingInt(Pair::level))
                                 .map(v -> v.value)
                                 .collect(Collectors.toList()))
                .collect(Collectors.toList());
   }

   private static void rec(TreeNode node, int i, int level, Map<Integer, List<Pair>> map) {
      if (node != null) {
         if (!map.containsKey(i)) {
            map.put(i, new ArrayList<>());
         }
         map.get(i).add(new Pair(node.val, level));
         rec(node.left, i - 1, level + 1, map);
         rec(node.right, i + 1, level + 1, map);
      }
   }

   private record Pair(int value, int level) {

   }

   static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
         this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
}
