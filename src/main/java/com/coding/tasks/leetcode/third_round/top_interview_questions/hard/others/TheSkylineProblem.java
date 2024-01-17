package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {

   public static void main(String[] args) {
      System.out.println(getSkyline(new int[][]{
         {2, 9, 10},
         {3, 7, 15},
         {5, 12, 12},
         {15, 20, 10},
         {19, 24, 8},
      })); // [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]

      System.out.println(getSkyline(new int[][]{
         {1, 2, 1},
         {1, 2, 2},
         {1, 2, 3}
      })); // [[0, 3], [5, 0]]

      System.out.println(getSkyline(new int[][]{
         {0, 2, 3},
         {2, 5, 3}
      })); // [[0, 3], [5, 0]]
   }

   public static List<List<Integer>> getSkyline(int[][] buildings) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Edge> allEdges = new ArrayList<>();
      for (int i = 0; i < buildings.length; i++) {
         allEdges.add(new Edge(buildings[i][0], i, true));
         allEdges.add(new Edge(buildings[i][1], i, false));
      }
      allEdges.sort((o1, o2) -> {
         if (o1.xEdge != o2.xEdge) {
            return o1.xEdge - o2.xEdge;
         } else if (o1.isStart != o2.isStart) {
            return Boolean.compare(o2.isStart, o1.isStart);
         } else {
            return Integer.compare(buildings[o2.buildingIndex][2], buildings[o1.buildingIndex][2]);
         }
      });
      Queue<Live> heightQueue = new PriorityQueue<>(Comparator.comparingInt(Live::height).reversed()); // [height, index in buildings]
      for (Edge edge : allEdges) {
         while (!heightQueue.isEmpty() && heightQueue.peek().end <= edge.xEdge) {
            heightQueue.poll();
         }

         if (edge.isStart) {
            heightQueue.add(new Live(buildings[edge.buildingIndex][2], buildings[edge.buildingIndex][1]));
         }

         int currentHeight = heightQueue.isEmpty() ? 0 : heightQueue.peek().height;
         if (ans.size() == 0 || currentHeight != ans.get(ans.size() - 1).get(1)) {
            ans.add(List.of(edge.xEdge, currentHeight));
         }
      }

      return ans;
   }

   private record Edge(int xEdge, int buildingIndex, boolean isStart) {

   }

   private record Live(int height, int end) {

   }
}
