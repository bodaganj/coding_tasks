package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.design;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

   class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   class Codec {

      // 1,#2,3,#__4,5,#____#
      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
         if (root == null) {
            return "";
         }
         StringBuilder sb = new StringBuilder();
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
               TreeNode poll = queue.poll();
               if (poll != null) {
                  sb.append(poll.val).append(",");
                  queue.add(poll.left);
                  queue.add(poll.right);
               } else {
                  sb.append("_,");
               }
               size--;
            }
            sb.append("#");
         }
         return sb.toString();
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
         if (Objects.equals(data, "")) {
            return null;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         String[] splitByLevels = data.split("#");
         TreeNode root = new TreeNode(Integer.parseInt(splitByLevels[0].split(",")[0]));
         queue.add(root);

         for (int i = 1; i < splitByLevels.length; i++) {
            String[] splitByLevel = splitByLevels[i].split(",");
            int size = queue.size();
            int index = 0;
            while (size > 0) {
               TreeNode poll = queue.poll();
               String left = splitByLevel[index++];
               String right = splitByLevel[index++];
               if (!Objects.equals(left, "_")) {
                  TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                  poll.left = leftNode;
                  queue.add(leftNode);
               }
               if (!Objects.equals(right, "_")) {
                  TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                  poll.right = rightNode;
                  queue.add(rightNode);
               }
               size--;
            }
         }

         return root;
      }
   }
}
