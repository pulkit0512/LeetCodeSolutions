class Solution {
    public int smallestCommonElement(int[][] mat) {
        //return smallestCommonElementUsingSet(mat);
        
        return smallestCommonElementUsingRowPointers(mat);
    }
    
    // TC: O(MN), SC: O(M) M rows and N cols
    private int smallestCommonElementUsingRowPointers(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int row[] = new int[m];
        
        int col = 0;
        while(col<n) {
            int min = Integer.MAX_VALUE;
            
            for(int i=0;i<m;i++){
                min = Math.min(min, mat[i][row[i]]);
            }
            
            int cnt = 0;
            for(int i=0;i<m;i++){
                if(mat[i][row[i]] == min){
                    row[i]++;
                    cnt++;
                    
                    col = Math.max(col, row[i]);
                }
            }
            
            if(cnt==m){
                return min;
            }
        }
        
        return -1;
    }
    
    // TC: O(MN), SC: O(MN)
    private int smallestCommonElementUsingSet(int[][] mat) {
        LinkedHashSet<Integer> prev = new LinkedHashSet<>();
        
        for(int i=0;i<mat[0].length;i++){
            prev.add(mat[0][i]);
        }
        
        for(int i=1;i<mat.length;i++){
            LinkedHashSet<Integer> curr = new LinkedHashSet<>();
            for(int j=0;j<mat[0].length;j++){
                if(prev.contains(mat[i][j])){
                    curr.add(mat[i][j]);
                }
            }
            
            prev = curr;
        }
        
        if(prev.isEmpty()){
            return -1;
        }else{
            return prev.iterator().next();
        }
    }
}