/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    Robot robot;
    // Set to keep track of visited cell.
    Set<Pair<Integer, Integer>> visitedSet;
    
    // Going clockwise: up {1, 0}, right {0, 1}, down {-1, 0}, left {0, -1}
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.visitedSet = new HashSet<>();
        dfs(0, 0, 0);
    }
    
    private void dfs(int row, int col, int D) {
        visitedSet.add(new Pair(row, col));
        robot.clean();
        
        for(int i=0;i<4;i++){
            int newD = (D+i)%4;
            int newRow = row + dir[newD][0];
            int newCol = col + dir[newD][1];
            if(!visitedSet.contains(new Pair(newRow, newCol)) && robot.move()) {
                dfs(newRow, newCol, newD);
                goBack();
            }
            robot.turnRight();
        }
    }
    
    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}