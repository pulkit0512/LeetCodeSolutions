class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //return combinationSumDP(candidates, target);
        return combinationSumBacktrack(candidates, target);
    }
    
    private List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target+1];
        for(int i=0;i<=target;i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());
        
        for(int i=0;i<candidates.length;i++){
            for(int j=candidates[i];j<=target;j++){
                for(List<Integer> list:dp[j-candidates[i]]){
                    dp[j].add(new ArrayList<>(list));
                    dp[j].get(dp[j].size()-1).add(candidates[i]);
                }
            }
        }
        return dp[target];
    }
    
    private List<List<Integer>> combinationSumBacktrack(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, int start) {
        if(target==0){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            cur.add(candidates[i]);
            backtrack(candidates, target-candidates[i], result, cur, i);
            cur.remove(cur.size()-1);
        }
    }
}