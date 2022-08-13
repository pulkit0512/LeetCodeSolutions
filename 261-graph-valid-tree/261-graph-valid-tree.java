class Solution {
    int[] root, rank;
    int connected;
    public boolean validTree(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        connected = n;
        for(int i=0;i<n;i++){
            rank[i] = 1;
            root[i] = i;
        }
        for(int[] edge:edges){
            if(!union(edge[0], edge[1])){
                return false;
            }
        }
        return connected == 1;
    }
    
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY){
            return false;
        }else{
            if(rank[rootX]>rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX]<rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
            connected--;
            return true;
        }
    }
    
    private int find(int x) {
        if(root[x]==x){
            return x;
        }
        return root[x] = find(root[x]);
    }
}