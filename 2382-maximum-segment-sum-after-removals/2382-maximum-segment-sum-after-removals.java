class Solution {
    int[] rank;
    long[] root;
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] ans = new long[n];
        root = new long[n];
        rank = new int[n];
        int[] copy = new int[n];
        for(int i=0;i<n;i++){
            rank[i] = 1;
            root[i] = -nums[i];
            copy[i] = -1;
        }
        
        long curMax = 0;
        for(int i=n-1;i>=0;i--){
            ans[i] = curMax;
            int idx = removeQueries[i];
            copy[idx] = nums[idx];
            if(idx>0 && copy[idx-1]!=-1){
                union(idx, idx-1);
            }
            if(idx<n-1 && copy[idx+1]!=-1){
                union(idx, idx+1);
            }
            int rootIdx = find(idx);
            curMax = Math.max(curMax, -root[rootIdx]);
        }
        
        return ans;
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        long valX = root[rootX];
        long valY = root[rootY];
        
        if(rootX==rootY){
            return;
        }
        if(rank[rootX]>rank[rootY]){
            root[rootY] = rootX;
            root[rootX] = valX + valY;
            rank[rootX] += rank[rootY];
        }else{
            root[rootX] = rootY;
            root[rootY] = valX + valY;
            rank[rootY] += rank[rootX];
        }
    }
    
    private int find(int x) {
        long x1 = x;
        while(root[(int)x1]>=0){
            x1 = root[(int)x1];
        }
        return (int)x1;
    }
}