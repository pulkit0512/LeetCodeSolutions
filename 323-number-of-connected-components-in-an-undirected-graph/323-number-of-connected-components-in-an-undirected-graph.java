class Solution {
    int[] root, rank;
    int cnt;
    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        cnt = n;
        
        for(int i=0;i<n;i++){
            root[i] = i;
            rank[i] = 1;
        }
        
        for(int[] edge:edges) {
            union(edge[0], edge[1]);
        }
        
        return cnt;
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX!=rootY){
            if(rank[rootX]>rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootY]>rank[rootX]){
                root[rootX] = rootY;
            }else{
                rank[rootX] += 1;
                root[rootY] = rootX;
            }
            cnt--;
        }
    }
    
    private int find(int x) {
        if(root[x]==x){
            return x;
        }
        return root[x] = find(root[x]);
    }
}