class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] inDegree = new ArrayList[numCourses];
        int[] outDegree = new int[numCourses];
        for(int[] pre:prerequisites){
            if(inDegree[pre[1]]==null){
                inDegree[pre[1]] = new ArrayList<>();
            }
            inDegree[pre[1]].add(pre[0]);
            outDegree[pre[0]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(outDegree[i]==0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int course = que.poll();
            if(inDegree[course]==null){
                continue;
            }
            for(int x:inDegree[course]){
                outDegree[x]--;
                if(outDegree[x]==0){
                    que.add(x);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(outDegree[i]!=0){
                return false;
            }
        }
        return true;
    }
}