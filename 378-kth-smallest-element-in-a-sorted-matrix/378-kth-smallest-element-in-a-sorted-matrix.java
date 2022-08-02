class Solution {
    class Data {
        int row, col, val;
        public Data(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> (a.val-b.val));
        int minRows = Math.min(k, matrix.length);
        for(int i=0;i<minRows;i++){
            pq.add(new Data(i, 0, matrix[i][0]));
        }
        while(k>0){
            Data cur = pq.poll();
            k--;
            if(k==0){
                return cur.val;
            }
            if(cur.col<matrix[0].length-1){
                pq.add(new Data(cur.row, cur.col + 1, matrix[cur.row][cur.col+1]));
            }
        }
        
        return -1;
    }
}