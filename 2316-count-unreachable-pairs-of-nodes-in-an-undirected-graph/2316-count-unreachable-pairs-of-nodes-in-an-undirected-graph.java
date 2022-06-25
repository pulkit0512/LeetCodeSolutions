class Solution {
    static long cnt;
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        boolean vis[] = new boolean[n];
        long ans = 0;
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt = 0;
                dfs(graph, vis, i);
                //System.out.println(i+" "+cnt);
                ans = ans + (cnt*(n-cnt));
            }
        }
        return ans/2;
    }
    
    private void dfs(List<Integer>[] graph, boolean vis[], int idx){
        if(vis[idx]){
            return;
        }
        cnt++;
        vis[idx] = true;
        for(int i=0;i<graph[idx].size();i++){
            if(!vis[graph[idx].get(i)]){
                dfs(graph, vis, graph[idx].get(i));
            }
        }
    }
}