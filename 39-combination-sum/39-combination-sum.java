class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target+1];
        for(int i=0;i<=target;i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());
        //Arrays.sort(candidates);
        for(int i=0;i<candidates.length;i++){
            for(int j=candidates[i];j<=target;j++){
                for(List<Integer> list:dp[j-candidates[i]]){
                    dp[j].add(new ArrayList<>(list));
                    dp[j].get(dp[j].size()-1).add(candidates[i]);
                }
            }
        }
        /*for(int i=0;i<=target;i++){
            System.out.println(dp[i]);
        }*/
        return dp[target];
    }
}