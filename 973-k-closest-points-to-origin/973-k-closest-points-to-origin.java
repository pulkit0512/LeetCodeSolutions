class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1])-(a[0]*a[0] + a[1]*a[1]));
        for(int i=0;i<k;i++){
            pq.add(points[i]);
        }
        for(int i=k;i<points.length;i++){
            int x = points[i][0]*points[i][0];
            int y = points[i][1]*points[i][1];
            int x1 = pq.peek()[0]*pq.peek()[0];
            int y1 = pq.peek()[1]*pq.peek()[1];
            if(x1+y1>x+y){
                pq.poll();
                pq.add(points[i]);
            }
        }
        int ans[][] = new int[pq.size()][2];
        int idx = 0;
        while(!pq.isEmpty()){
            ans[idx++] = pq.poll();
        }
        return ans;
    }
}