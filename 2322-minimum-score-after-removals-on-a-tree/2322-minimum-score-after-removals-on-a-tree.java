class Solution {
    // Great Explaination: https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/discuss/2198665/Python-3-Explanation-with-pictures-BFS
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        List<Set<Integer>> children = new ArrayList<>(n);
        boolean vis[] = new boolean[n];
        int[] deg = new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            children.add(new HashSet<>());
        }
        // Creating undirected graph from edges
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            deg[edge[0]]++;
            deg[edge[1]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        int xor = 0;
        // finding xor of all elements and if only one edge for a node then it's a child node add it in queue.
        for(int i=0;i<n;i++){
            xor = xor^nums[i];
            if(deg[i]==1){
                que.add(i);
            }
        }
        // BFS traversal similar to topological sort to process leaf nodes first and then reducing there degree
        // from parent nodes and if we got any leaf node not yet visited add it in queue.
        // This is done to get xor of a subtree rooted a node and all the children in that subtree including self.
        while(!que.isEmpty()){
            int cur = que.poll();
            vis[cur] = true;
            for(int child:graph.get(cur)){
                if(!vis[child]){
                    children.get(child).add(cur);
                    children.get(child).addAll(children.get(cur));
                    nums[child] = nums[child]^nums[cur];
                    deg[child]--;
                    if(deg[child]==1){
                        que.add(child);
                    }
                }
            }
        }
        // Three cases for each pair edge. Let u1 and u2 be lower break points
        // 1) u2 is child of u1
        // 2) u1 is child of u2
        // 3) both are independent trees
        // for case1 three xors will be totalXor^u1Xor, u1Xor^u2Xor, u2Xor
        // for case2 three xors will be totalXor^u2Xor, u2Xor^u1Xor, u1Xor
        // for case3 three xors will be totalXor^u1Xor^u2Xor, u1Xor, u2Xor
        // return maxXor-minXor for each case.
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            int u1 = edges[i][0];
            int v1 = edges[i][1];
            if(children.get(u1).contains(v1)){
                int temp = u1;
                u1 = v1;
                v1 = temp;
            }
            
            for(int j=i+1;j<edges.length;j++){
                int u2 = edges[j][0];
                int v2 = edges[j][1];
                if(children.get(u2).contains(v2)){
                    int temp = u2;
                    u2 = v2;
                    v2 = temp;
                }
                int val1, val2, val3;
                if(children.get(u1).contains(u2)){
                    val1 = nums[u2];
                    val2 = nums[u1]^nums[u2];
                    val3 = xor^nums[u1];
                }else if(children.get(u2).contains(u1)){
                    val1 = nums[u1];
                    val2 = nums[u2]^nums[u1];
                    val3 = xor^nums[u2];
                }else{
                    val1 = nums[u1];
                    val2 = nums[u2];
                    val3 = xor^nums[u1]^nums[u2];
                }
                int max = Math.max(val1, Math.max(val2, val3));
                int min = Math.min(val1, Math.min(val2, val3));
                ans = Math.min(ans, max-min);
            }
        }
        return ans;
    }
}