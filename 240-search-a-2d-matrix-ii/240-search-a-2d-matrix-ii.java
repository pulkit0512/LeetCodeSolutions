class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for(int i=0;i<m;i++){
            int val = Arrays.binarySearch(matrix[i], target);
            if(val>=0){
                return true;
            }
        }
        return false;
    }
}