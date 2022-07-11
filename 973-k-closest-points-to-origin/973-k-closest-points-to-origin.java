class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[2]-a[2]));
        for(int[] point:points){
            int dist = point[0]*point[0] + point[1]*point[1];
            pq.add(new int[]{point[0], point[1], dist});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int idx = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            ans[idx][0] = temp[0];
            ans[idx][1] = temp[1];
            idx++;
        }
        return ans;
    }
}