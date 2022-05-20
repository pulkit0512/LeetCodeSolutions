class Solution {
    /*class pair{
        HashSet<Integer> inEdge;
        HashSet<Integer> outEdge;
        pair(){
            inEdge = new HashSet<>();
            outEdge = new HashSet<>();
        }
    }
    private int[] findOrderUsingMap(int numCourses, int[][] prerequisites){
        Map<Integer, pair> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i, new pair());
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).outEdge.add(prerequisites[i][1]);
            graph.get(prerequisites[i][1]).inEdge.add(prerequisites[i][0]);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(graph.size()>0){
            int outKey = -1;
            for(int key:graph.keySet()){
                if(graph.get(key).outEdge.size()==0){
                    outKey = key;
                }
            }
            if(outKey == -1){
                return new int[0];
            }
            for(int x:graph.get(outKey).inEdge){
                graph.get(x).outEdge.remove(outKey);
            }
            graph.remove(outKey);
            ans[idx++] = outKey;
        }
        return ans;
    }*/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // using hashmaps
        // return findOrderUsingMap(numCourses, prerequisites);
        
        // using arraylist and queus for BFS efficient solution
        return findOrderBFS(numCourses, prerequisites);
    }
    private int[] findOrderBFS(int numCourses, int[][] prerequisites){
        int ans[] = new int[numCourses];
        int out[] = new int[numCourses];
        List<List<Integer>> inDegree = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            inDegree.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            inDegree.get(pre[1]).add(pre[0]);
            out[pre[0]]++;
        }
        System.out.println(inDegree);
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(out[i]==0){
                que.add(i);
            }
        }
        int idx = 0;
        while(!que.isEmpty()){
            int temp = que.poll();
            ans[idx++] = temp;
            for(int val:inDegree.get(temp)){
                out[val]--;
                if(out[val]==0){
                    que.add(val);
                }
            }
        }
        if(idx==numCourses){
            return ans;
        }else{
            return new int[0];
        }
    }
}