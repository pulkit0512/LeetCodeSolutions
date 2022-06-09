class Solution {
    int rank[], root[];
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(new int[]{0, i+1, wells[i]});
        }
        for(int i=0;i<pipes.length;i++){
            edges.add(new int[]{pipes[i][0], pipes[i][1], pipes[i][2]});
        }
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        rank = new int[n+1];
        root = new int[n+1];
        for(int i=0;i<=n;i++){
            root[i] = i;
            rank[i] = 1;
        }
        int totalCost = 0;
        int cnt=0;
        for(int i=0;i<edges.size();i++){
            if(union(edges.get(i)[0], edges.get(i)[1])){
                totalCost += edges.get(i)[2];
                cnt++;
            }
            if(cnt==n){
                break;
            }
        }
        return totalCost;
    }
    
    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY){
            return false;
        }
        if(rank[rootX]<rank[rootY]){
            root[rootX] = rootY;
        } else if(rank[rootY]<rank[rootX]){
            root[rootY] = rootX;
        } else{
            root[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
    public int find(int x){
        if(x==root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
}