class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        // compute 2D prefix sum
        int[][] preSum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int count = 0, currSum;
        Map<Integer, Integer> map = new HashMap();
        // reduce 2D problem to 1D one
        // by fixing two rows r1 and r2 and 
        // computing 1D prefix sum for all matrices using [r1..r2] rows
        for (int r1 = 1; r1 <= row; r1++) {
            for (int r2 = r1; r2 <= row; r2++) {
                map.clear();
                map.put(0, 1);
                for (int c = 1; c <= col; c++) {
                    // current 1D prefix sum
                    currSum = preSum[r2][c] - preSum[r1 - 1][c];
                    // add subarrays which sum up to (currSum - target)
                    count += map.getOrDefault(currSum - target, 0);
                    // save current prefix sum
                    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
                }
            }
        }
        return count;
    }
}