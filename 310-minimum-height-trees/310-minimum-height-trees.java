class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
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
                    result = new ArrayList<>();
                }
                continue;
            }
            result.add(node);
            for(int x:graph[node]){
                graph[node].remove(x);
                graph[x].remove(node);
                if(graph[x].size()==1){
                    que.add(x);
                }
            }
        }
        return result;
    }
}