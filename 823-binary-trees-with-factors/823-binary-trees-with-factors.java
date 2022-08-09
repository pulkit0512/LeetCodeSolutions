class Solution {
    int mod = 1000000007;
    Map<Integer, Integer> dp;
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Set<Integer>> factorMap = new HashMap<>();
        for(int x:arr){
            factorMap.put(x, new HashSet<>());
            for(int y:arr){
                if(x%y==0){
                    factorMap.get(x).add(y);
                }
            }
        }
        //System.out.println(factorMap);
        int ans = 0;
        dp = new HashMap<>();
        for(int x:arr){
            ans = (ans + dfs(factorMap, x))%mod;
        }
        return ans;
    }
    
    private int dfs(Map<Integer, Set<Integer>> factorMap, int x) {
        if(dp.containsKey(x)){
            return dp.get(x);
        }
        Set<Integer> factorSet = factorMap.get(x);
        int cur = 1;
        for(int factor:factorSet){
            if(factor!=x && factorMap.containsKey(x/factor)){
                long val1 = dfs(factorMap, factor);
                long val2 = val1;
                if(factor!=x/factor){
                    val2 = dfs(factorMap, x/factor);
                }
                cur = (cur + (int)((val1*val2)%mod))%mod;
            }
        }
        dp.put(x, cur);
        return cur;
    }
}