class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        for(int i=0;i<k;i++){
            int x = points[i][0]*points[i][0];
            int y = points[i][1]*points[i][1];
            pq.add(new int[]{points[i][0], points[i][1], x+y});
        }
        for(int i=k;i<points.length;i++){
            int x = points[i][0]*points[i][0];
            int y = points[i][1]*points[i][1];
            if(pq.peek()[2]>x+y){
                pq.poll();
                pq.add(new int[]{points[i][0], points[i][1], x+y});
            }
        }
        int ans[][] = new int[pq.size()][2];
        int idx = 0;
        while(!pq.isEmpty()){
            ans[idx][0] = pq.peek()[0];
            ans[idx][1] = pq.peek()[1];
            pq.poll();
            idx++;
        }
        return ans;
    }
}