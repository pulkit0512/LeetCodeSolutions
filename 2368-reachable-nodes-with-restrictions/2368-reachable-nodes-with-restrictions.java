class Solution {
    int maxNodes;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        boolean[] vis = new boolean[n];
        for(int restrict:restricted){
            set.add(restrict);
        }
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        maxNodes = 0;
        dfs(graph, set, 0, vis);
        return maxNodes;
    }
    
    private void dfs(List<Integer>[] graph, Set<Integer> set, int node, boolean[] vis) {
        if(vis[node]){
            return;
        }
        vis[node] = true;
        maxNodes++;
        //System.out.println(node +" "+ graph[node]);
        for(int x:graph[node]){
            if(!set.contains(x)){
                dfs(graph, set, x, vis);
            }
        }
    }
}