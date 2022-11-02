class Solution {
    public int smallestCommonElement(int[][] mat) {
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