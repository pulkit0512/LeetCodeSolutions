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
        //return kthSmallestUsingPriorityQueue(matrix, k);
        return kthSmallestUsingBinarySearch(matrix, k);
    }
    
    // Time Complexity: O(NLog(Max-Min))
    // Space Complexity: O(1)
    private int kthSmallestUsingBinarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        while(min<max){
            // get lower value of mid.
            int mid = max+min;
            if(mid<0){
                mid = (mid-1)/2;
            }else{
                mid = mid/2;
            }
            int[] midData = getMidData(matrix, mid);
            if(midData[0] == k){
                return midData[1];
            }else if(midData[0]>k){
                max = midData[1];
            }else{
                min = midData[2];
            }
        }
        return min;
    }
    
    // midData[0] = count of elements less then equal to mid
    // midData[1] = largest element smaller then mid
    // midData[2] = smallest element larget then mid
    private int[] getMidData(int[][] matrix, int mid) {
        int[] midData = new int[3];
        int n = matrix.length;
        midData[1] = matrix[0][0];
        midData[2] = matrix[n-1][n-1];
        int i = n-1, j = 0;
        while(i>=0 && j<n) {
            if(matrix[i][j]<=mid){
                midData[1] = Math.max(midData[1], matrix[i][j]);
                midData[0] += i+1;
                j++;
            }else{
                midData[2] = Math.min(midData[2], matrix[i][j]);
                i--;
            }
        }
        return midData;
    }
    
    // Time Complexity: O(Min(K, N) + KLog(Min(k, N)))
    // Space Complexity: O(Min(K, N))
    private int kthSmallestUsingPriorityQueue(int[][] matrix, int k) {
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