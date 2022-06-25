class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0){
            return 0;
        }
        List<Integer> cand = new ArrayList<>();
        int sum = k;
        while(sum<=num){
            cand.add(sum);
            sum += 10;
        }
        int dp[] = new int[num+1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for(int i=0;i<cand.size();i++){
            for(int j=cand.get(i);j<=num;j++){
                dp[j] = Math.min(dp[j], dp[j-cand.get(i)] + 1);
            }
        }
        return dp[num]==10000?-1:dp[num];
    }
}