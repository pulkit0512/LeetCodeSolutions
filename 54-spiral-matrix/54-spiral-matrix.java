class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n-1;
        int up = 0, down = m-1;
        int size = m*n;
        while(order.size()<size){
            for(int i=left;i<=right;i++){
                order.add(matrix[up][i]);
            }
            for(int i=up+1;i<=down;i++){
                order.add(matrix[i][right]);
            }
            if(up!=down){
                for(int i=right-1;i>=left;i--){
                    order.add(matrix[down][i]);
                }
            }
            if(left!=right){
                for(int i=down-1;i>up;i--){
                    order.add(matrix[i][left]);
                }
            }
            up++;
            down--;
            right--;
            left++;
        }
        return order;
    }
}