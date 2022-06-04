class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int up = 0, down = n-1;
        int left = 0, right = m-1;
        while(list.size()!=n*m){
            for(int col=left;col<=right;col++){
                list.add(matrix[up][col]);
            }
            for(int row=up+1;row<=down;row++){
                list.add(matrix[row][right]);
            }
            if(up!=down){
                for(int col=right-1;col>=left;col--){
                    list.add(matrix[down][col]);
                }
            }
            if(left!=right){
                for(int row=down-1;row>up;row--){
                    list.add(matrix[row][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
        return list;
    }
}