class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
        }
        
        if(graph.containsKey(destination)){
            return false;
        }
        
        int[] vis = new int[n];
        
        return dfs(graph, vis, source, destination);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int[] vis, int src, int dest) {
        if(vis[src]!=0){
            return vis[src]==1;
        }
        
        if(graph.containsKey(src)){
            vis[src] = 2;
            for(int x:graph.get(src)){
                if(!dfs(graph, vis, x, dest)){
                    return false;
                }
            }
            vis[src] = 1;
            return true;
        }else{
            return src==dest;
        }
    }
}