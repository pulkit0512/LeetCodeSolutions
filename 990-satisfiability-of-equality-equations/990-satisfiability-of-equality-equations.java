class Solution {
    int root[], rank[];
    public boolean equationsPossible(String[] equations) {
        root = new int[26];
        rank = new int[26];
        
        for(int i=0;i<26;i++){
            root[i] = i;
            rank[i] = 1;
        }
        
        for(String equation:equations) {
            char left = equation.charAt(0);
            char right = equation.charAt(3);
            
            if(equation.charAt(1)=='='){
                union(left-'a', right-'a');
            }
        }
        
        for(String equation:equations) {
            char left = equation.charAt(0);
            char right = equation.charAt(3);
            
            if(equation.charAt(1)=='!'){
                int leftRoot = find(left-'a');
                int rightRoot = find(right-'a');
                
                if(leftRoot==rightRoot) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX!=rootY) {
            if(rank[rootX]<rank[rootY]){
                root[rootX] = rootY;
            }else if(rank[rootX]>rank[rootY]){
                root[rootY] = rootX;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
    
    private int find(int x) {
        if(root[x]==x){
            return x;
        }
        return root[x] = find(root[x]);
    }
}