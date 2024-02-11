package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrderTraversal {

   public static List<List<Integer>> verticalOrder(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      Map<Integer, List<TreeNode>> map = new TreeMap<>();
      rec(root, 0, map);

      return map.values().stream().map(list -> list.stream().map(v -> v.val).collect(Collectors.toList())).collect(Collectors.toList());
   }

   private static void rec(TreeNode node, int i, Map<Integer, List<TreeNode>> map) {
      if (node != null) {
         if (!map.containsKey(i)) {
            map.put(i, new ArrayList<>());
         }
         map.get(i).add(node);
         rec(node.left, i - 1, map);
         rec(node.right, i + 1, map);
      }
   }

   public class TreeNode {

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
