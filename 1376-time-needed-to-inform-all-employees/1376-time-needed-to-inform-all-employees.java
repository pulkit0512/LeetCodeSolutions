class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            if(i==headID){
                continue;
            }
            if(graph[manager[i]]==null){
                graph[manager[i]] = new ArrayList<>();
            }
            graph[manager[i]].add(i);
        }
        return dfsInformTime(headID, graph, informTime);
    }
    
    private int dfsInformTime(int id, List<Integer>[] graph, int[] informTime) {
        if(graph[id]==null){
            return 0;
        }
        int time = 0;
        for(int i=0;i<graph[id].size();i++){
            time = Math.max(time, dfsInformTime(graph[id].get(i), graph, informTime));
        }
        return time + informTime[id];
    }
}