class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((b[0]*b[0] + b[1]*b[1])-(a[0]*a[0] + a[1]*a[1])));
        for(int[] point:points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int idx = 0;
        while(!pq.isEmpty()){
            ans[idx++] = pq.poll();
        }
        return ans;
    }
}