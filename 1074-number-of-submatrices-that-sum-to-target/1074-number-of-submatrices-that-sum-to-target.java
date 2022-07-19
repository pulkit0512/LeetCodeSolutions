class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int preSum[][] = new int[row+1][col+1];
        //Compute 2D prefix Sum
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        // Map to store subarray counts for a particular sum
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int r1 = 1;r1 <= row;r1++){
            for(int r2=r1;r2 <= row;r2++){
                map.clear();
                map.put(0,1);
                for(int c=1;c<=col;c++){
                    //Compute 1D Subarray sum for particular column between two rows.
                    int curSum = preSum[r2][c] - preSum[r1-1][c];
                    // add the number of subarrays to the count whose sum equal to curSum-target
                    count += map.getOrDefault(curSum-target, 0);
                    // increse frequency of curSum.
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return count;
    }
}