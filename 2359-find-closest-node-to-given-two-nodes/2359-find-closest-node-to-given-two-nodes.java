class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] map1 = new int[edges.length];
        int[] map2 = new int[edges.length];
        for(int i=0;i<edges.length;i++){
            map1[i] = -1;
            map2[i] = -1;
        }
        boolean[] vis1 = new boolean[edges.length];
        boolean[] vis2 = new boolean[edges.length];
        
        dfs(edges, vis1, map1, node1, 0);
        dfs(edges, vis2, map2, node2, 0);
        
        int dist = Integer.MAX_VALUE;
        int node = -1;
        for(int i=0;i<map1.length;i++){
            if(map1[i]!=-1 && map2[i]!=-1){
                int cur = Math.max(map1[i], map2[i]);
                if(cur<dist){
                    dist = cur;
                    node = i;
                }
            }
        }
        
        return node;
    }
    
    private void dfs(int[] edges, boolean[] vis, int[] map, int node, int dist) {
        if(node==-1 || vis[node]){
            return;
        }
        map[node] = dist;
        vis[node] = true;
        dfs(edges, vis, map, edges[node], dist+1);
    }
}