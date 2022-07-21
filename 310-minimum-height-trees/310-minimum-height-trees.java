class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] level = new int[n];
        int lvl = 0;
        Set<Integer>[] graph = new HashSet[n];
        for(int i=0;i<n;i++){
            graph[i] = new HashSet<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(graph[i].size()==1){
                que.add(i);
            }
        }
        que.add(null);
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()){
            Integer node = que.poll();
            if(node==null){
                if(!que.isEmpty()){
                    que.add(null);
                    lvl++;
                }
                continue;
            }
            level[node] = lvl;
            for(int x:graph[node]){
                graph[node].remove(x);
                graph[x].remove(node);
                if(graph[x].size()==1){
                    que.add(x);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(level[i]==lvl){
                result.add(i);
            }
        }
        return result;
    }
}