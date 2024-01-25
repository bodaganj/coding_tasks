package com.coding.tasks.leetcode.third_round.top_interview_questions.google.trees.and.graphs;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

   private static int turnCount = 0;
   private static int[][] turnRightDirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

   public static void cleanRoom(Robot robot) {
      Set<Point> set = new HashSet<>();
      rec(0, 0, 0, -1, set, robot);
   }

   private static void rec(int x, int y, int xCh, int yCh, Set<Point> set, Robot robot) {
      Point point = new Point(x, y);
      System.out.println("Clean " + x + " " + y);
      robot.clean();
      set.add(point);

      if (!set.contains(new Point(x + xCh, y + yCh)) && robot.move()) {
         System.out.println("first move");
         rec(x + xCh, y + yCh, xCh, yCh, set, robot);
      }

      int[] turn = turnRightDirs[turnCount % 4];
      int turnX = turn[0];
      int turnY = turn[1];
      if (!set.contains(new Point(x + turnX, y + turnY))) {
         System.out.println("Turn right");
         robot.turnRight();
         turnCount++;
         if (robot.move()) {
            System.out.println("second move");
            rec(x + turnX, y + turnY, turnX, turnY, set, robot);
         }
         robot.turnLeft();
         turnCount--;
      }

      turn = turnRightDirs[turnCount % 4];
      turnX = turn[0] * -1;
      turnY = turn[1] * -1;
      if (!set.contains(new Point(x + turnX, y + turnY))) {
         System.out.println("Turn left");
         robot.turnLeft();
         turnCount++;
         if (robot.move()) {
            System.out.println("third move");
            rec(x + turnX, turnY, turnX, turnY, set, robot);
         }
         robot.turnLeft();
         turnCount--;
      }

      robot.turnRight();
      robot.turnRight();
      robot.move();
      robot.turnRight();
      robot.turnRight();
   }

   interface Robot {

      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
      public boolean move();

      // Robot will stay in the same cell after calling turnLeft/turnRight.
      // Each turn will be 90 degrees.
      public void turnLeft();

      public void turnRight();

      // Clean the current cell.
      public void clean();
   }

   private record Point(int i, int j) {

   }
}
