class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, result, new ArrayList<>(), 9);
        return result;
    }
    
    private void backtrack(int k, int n, List<List<Integer>> result, List<Integer> cur, int val) {
        if(k==0){
            if(n==0){
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        
        for(int i=val;i>0;i--){
            if(n-i>=0){
                cur.add(i);
                backtrack(k-1, n-i, result, cur, i-1);
                cur.remove(cur.size()-1);
            }
        }
    }
}