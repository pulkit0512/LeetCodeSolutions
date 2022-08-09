class Solution {
    int mod = 1000000007;
    Map<Integer, Integer> dp;
    public int numFactoredBinaryTrees(int[] arr) {
        //return numFactoredBinaryTreesMemoization(arr);
        return numFactoredBinaryTreesTabulation(arr);
    }
    
    private int numFactoredBinaryTreesTabulation(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long[] ans = new long[n];
        dp = new HashMap<>();
        for(int i=0;i<n;i++){
            ans[i] = 1;
            dp.put(arr[i], i);
        }
        int totalTrees = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && dp.containsKey(arr[i]/arr[j])){
                    int next = arr[i]/arr[j];
                    ans[i] = (ans[i] + (ans[j]*ans[dp.get(next)])%mod)%mod;
                }
            }
            totalTrees = (totalTrees + (int)ans[i])%mod;
        }
        return totalTrees;
    }
    
    private int numFactoredBinaryTreesMemoization(int[] arr) {
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