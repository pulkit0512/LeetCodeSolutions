class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int preSum[] = new int[n+1];
        for(int i=1;i<=n;i++){
            preSum[i] = preSum[i-1] + cardPoints[i-1];
        }
        int ans = preSum[k];
        for(int i=n-1;i>=n-k;i--){
            //preSum[n]-preSum[i] gives sum for elements from right boundary
            //preSum[k-(n-i)] gives sum for elements from left boundary
            //since we can cross boundary, for k=8 if we get 2 from right then we fetch 6 from left.
            ans = Math.max(ans, (preSum[n]-preSum[i])+preSum[k-(n-i)]);
        }
        return ans;
    }
}