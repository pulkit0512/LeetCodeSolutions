class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int preSum[] = new int[n+k];
        for(int i=1;i<n+k;i++){
            preSum[i] = preSum[i-1] + cardPoints[(i-1)%n];
        }
        int ans = preSum[k];
        for(int i=n-k;i<n;i++){
            ans = Math.max(ans, preSum[i+k]-preSum[i]);
        }
        return ans;
    }
}