class Solution {
    int result;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        result = Integer.MIN_VALUE;
        if(matrix[0].length>matrix.length) {
            for(int i=0;i<matrix.length;i++){
                // Stores the 1D representation of the matrix.
                int[] rowSum = new int[matrix[0].length];
            
                // We convert the matrix between rows i..row inclusive to 1D array
                for(int row=i;row<matrix.length;row++){
                    // Add the current row to the previous row.
                    // This converts the matrix between i..row to 1D array
                    for(int col=0;col<matrix[0].length;col++){
                        rowSum[col] += matrix[row][col];
                    }
                
                    // Run the 1D algorithm for `rowSum`
                    updateResult(rowSum, k);
                
                    // If result is k, this is the best possible answer, so return.
                    if(result == k){
                        return result;
                    }
                }
            }
        }else {
            for(int i=0;i<matrix[0].length;i++){
                // Stores the 1D representation of the matrix.
                int[] colSum = new int[matrix.length];
            
                // We convert the matrix between cols i..col inclusive to 1D array
                for(int col=i;col<matrix[0].length;col++){
                    // Add the current col to the previous col.
                    // This converts the matrix between i..col to 1D array
                    for(int row=0;row<matrix.length;row++){
                        colSum[row] += matrix[row][col];
                    }
                
                    // Run the 1D algorithm for `colSum`
                    updateResult(colSum, k);
                
                    // If result is k, this is the best possible answer, so return.
                    if(result == k){
                        return result;
                    }
                }
            }
        }
        return result;
    }
    
    private void updateResult(int[] nums, int k) {
        // To store sorted prefix sums.
        TreeSet<Integer> sortedSum = new TreeSet<>();
        
        int sum = 0;
        
        // Add 0 as the prefix sum for an empty sub-array.
        sortedSum.add(sum);
        
        for(int num:nums) {
            // Running Sum.
            sum += num;
            
            // Get X where Running sum - X <= k such that sum - X is closest to k.
            Integer x = sortedSum.ceiling(sum-k);
            
            // If such X is found in the prefix sums.
            // Get the sum of that sub array and update the global maximum result.
            if(x!=null){
                result = Math.max(result, sum-x);
            }
            
            if(result == k){
                return;
            }
            
            // Insert the current running sum to the prefix sums set
            sortedSum.add(sum);
        }
    }
}