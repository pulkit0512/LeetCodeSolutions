class Solution {
    int ans;
    int[] edges;
    int[] vis;
    public int longestCycle(int[] edges) {
        int[] dist = new int[edges.length];
        this.ans = -1;
        this.edges = edges;
        this.vis = new int[edges.length];
        for(int i=0;i<edges.length;i++){
            if(dist[i]==0){
                dfs(dist, i, 1, i);
            }
        }
        return ans;
    }
    
    private void dfs(int[] dist, int node, int cur, int idx) {
        if(node==-1){
            return;
        }
        if(dist[node]!=0){
            if(vis[node]==idx){
                ans = Math.max(ans, cur-dist[node]);
            }
            return;
        }
        dist[node] = cur;
        vis[node] = idx;
        dfs(dist, edges[node], cur+1, idx);
    }
}