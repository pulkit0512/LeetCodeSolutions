class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
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