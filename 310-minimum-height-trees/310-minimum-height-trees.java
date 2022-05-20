class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] level = new int[n];
        int color = 0;
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new HashSet<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(graph.get(i).size()==1){
                que.add(i);
            }
        }
        //System.out.println(graph);
        que.add(null);
        while(!que.isEmpty()){
            Integer temp = que.poll();
            if(temp==null){
                if(que.isEmpty()){
                    break;
                }
                color++;
                que.add(null);
                continue;
            }
            level[temp] = color;
            for(int x:graph.get(temp)){
                graph.get(x).remove(temp);
                graph.get(temp).remove(x);
                if(graph.get(x).size()==1){
                    que.add(x);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(level[i]==color){
                ans.add(i);
            }
        }
        return ans;
    }
}