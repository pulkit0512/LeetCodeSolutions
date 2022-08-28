class Solution {
    int result;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        result = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            // Initialize row sum
            int[] rowSum = new int[matrix[0].length];
            
            // Get prefix sum for all rectangles starting with row i.
            for(int row=i;row<matrix.length;row++){
                for(int col=0;col<matrix[0].length;col++){
                    rowSum[col] += matrix[row][col];
                }
                
                updateResult(rowSum, k);
                
                if(result == k){
                    return result;
                }
            }
        }
        return result;
    }
    
    private void updateResult(int[] rowSum, int k) {
        TreeSet<Integer> sortedSum = new TreeSet<>();
        
        int sum = 0;
        sortedSum.add(sum);
        
        for(int num:rowSum) {
            sum += num;
            
            Integer x = sortedSum.ceiling(sum-k);
            
            if(x!=null){
                result = Math.max(result, sum-x);
            }
            
            if(result == k){
                return;
            }
            
            sortedSum.add(sum);
        }
    }
}