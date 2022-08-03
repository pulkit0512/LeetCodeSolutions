class Solution {
    public int removeStones(int[][] stones) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = stones.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int ans = 0;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans += dfs(i, graph, vis)-1;
            }
        }
        return ans;
    }
    private int dfs(int idx, List<List<Integer>> graph, boolean vis[]){
        if(vis[idx]){
            return 0;
        }
        vis[idx] = true;
        int ret = 1;
        for(int x:graph.get(idx)){
            ret += dfs(x, graph, vis);
        }
        return ret;
    }
}