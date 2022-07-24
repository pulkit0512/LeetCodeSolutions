class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //return searchMatrixMLogN(matrix, target);
        return searchMatrixMPlusN(matrix, target);
    }
    
    private boolean searchMatrixMPlusN(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ptrRow = m-1, ptrCol = 0;
        while(ptrRow>=0 && ptrCol<n){
            if(matrix[ptrRow][ptrCol]>target){
                ptrRow--;
            }else if(matrix[ptrRow][ptrCol]<target){
                ptrCol++;
            }else{
                return true;
            }
        }
        return false;
    }
    
    private boolean searchMatrixMLogN(int[][] matrix, int target) {
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