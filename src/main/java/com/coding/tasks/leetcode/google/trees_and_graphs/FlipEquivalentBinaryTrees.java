package com.coding.tasks.leetcode.google.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FlipEquivalentBinaryTrees {

   private final List<Integer> allValues = new ArrayList<>();
   Map<Integer, List<Integer>> nodeMapping1 = new HashMap<>();
   Map<Integer, List<Integer>> nodeMapping2 = new HashMap<>();

   public static void main(String[] args) {
      FlipEquivalentBinaryTrees flipEquivalentBinaryTrees = new FlipEquivalentBinaryTrees();

      TreeNode t8 = new TreeNode(8);
      TreeNode t7 = new TreeNode(7);
      TreeNode t6 = new TreeNode(6);
      TreeNode t5 = new TreeNode(5, t7, t8);
      TreeNode t4 = new TreeNode(4);
      TreeNode t3 = new TreeNode(3, t6, null);
      TreeNode t2 = new TreeNode(2, t4, t5);
      TreeNode t1 = new TreeNode(1, t2, t3);

//      TreeNode n8 = new TreeNode(8);
//      TreeNode n7 = new TreeNode(7);
//      TreeNode n6 = new TreeNode(6);
//      TreeNode n5 = new TreeNode(5, n8, n7);
//      TreeNode n4 = new TreeNode(4);
//      TreeNode n3 = new TreeNode(3, null, n6);
//      TreeNode n2 = new TreeNode(2, n4, n5);
//      TreeNode n1 = new TreeNode(1, n3, n2);

      TreeNode n8 = new TreeNode(8);
      TreeNode n7 = new TreeNode(7);
      TreeNode n6 = new TreeNode(6);
      TreeNode n5 = new TreeNode(5, n8, n7);
      TreeNode n4 = new TreeNode(4);
      TreeNode n3 = new TreeNode(3, null, n6);
      TreeNode n2 = new TreeNode(2, n4, n5);
      TreeNode n1 = new TreeNode(99, n3, n2);

      /**
       * Get all values of Tree just for fun !!!!
       */
      System.out.println(flipEquivalentBinaryTrees.flipEquiv(t1, n1));
//      List<Integer> listOfAllValues = flipEquivalentBinaryTrees.getListOfAllValues(t1);
//      for (Integer listOfAllValue : listOfAllValues) {
//         System.out.println(listOfAllValue);
//      }
   }

   public boolean flipEquiv(TreeNode root1, TreeNode root2) {
      getNodeMapping(root1, nodeMapping1);
      getNodeMapping(root2, nodeMapping2);

      if (nodeMapping1.size() != nodeMapping2.size()) {
         return false;
      }

      if(!nodeMapping1.keySet().equals(nodeMapping2.keySet())) {
         return false;
      }

      for (Map.Entry<Integer, List<Integer>> entry : nodeMapping1.entrySet()) {
         Integer key = entry.getKey();
         List<Integer> integers1 = nodeMapping1.get(key);
         List<Integer> integers2 = nodeMapping2.get(key);
         if (!compareListsIgnoreOrder(integers1, integers2)) {
            return false;
         }
      }
      return true;
   }

   public List<Integer> getListOfAllValues(TreeNode node) {
      if (Objects.isNull(node)) {
         return Collections.emptyList();
      }

      allValues.add(node.val);
      getListOfAllValues(node.left);
      getListOfAllValues(node.right);
      return allValues;
   }

   private void getNodeMapping(TreeNode node, Map<Integer, List<Integer>> mapping) {
      if (node == null) {
         return;
      }
      mapping.put(node.val, List.of(node.left != null ? node.left.val : 0, node.right != null ? node.right.val : 0));
      getNodeMapping(node.left, mapping);
      getNodeMapping(node.right, mapping);
   }

   private boolean compareListsIgnoreOrder(List<Integer> list1, List<Integer> list2) {
      if (list1.size() != list2.size()) {
         return false;
      }
      for (Integer integer : list1) {
         if (!list2.contains(integer)) {
            return false;
         }
      }
      return true;
   }

   public static class TreeNode {

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
