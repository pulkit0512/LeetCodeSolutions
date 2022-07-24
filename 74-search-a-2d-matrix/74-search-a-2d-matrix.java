class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrixMPlusLogN(matrix, target);
        //return searchMatrixMPlusN(matrix, target);
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
    
    private boolean searchMatrixMPlusLogN(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        for(int i=0;i<m;i++){
            if(target>=matrix[i][0]){
                row = i;
            }else{
                break;
            }
        }
        int val = Arrays.binarySearch(matrix[row], target);
        return val>=0;
    }
}