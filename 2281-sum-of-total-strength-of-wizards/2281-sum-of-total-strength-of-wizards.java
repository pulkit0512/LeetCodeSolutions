class Solution {
    int mod = 1000000007;
    public int totalStrength(int[] strength) {
        int n = strength.length;
        long[] preSum = new long[n+1];
        long[] prePreSum = new long[n+2];
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> leftSt = new Stack<>();
        Stack<Integer> rightSt = new Stack<>();
        for(int i=0;i<n;i++){
            preSum[i+1] = (preSum[i] + strength[i])%mod;
        }
        for(int i=0;i<=n;i++){
            prePreSum[i+1] = (prePreSum[i] + preSum[i])%mod;
        }
        for(int i=0;i<n;i++){
            while(!leftSt.isEmpty() && strength[leftSt.peek()]>=strength[i]){
                leftSt.pop();
            }
            left[i] = leftSt.isEmpty()?-1:leftSt.peek();
            leftSt.push(i);
            while(!rightSt.isEmpty() && strength[rightSt.peek()]>strength[n-1-i]){
                rightSt.pop();
            }
            right[n-1-i] = rightSt.isEmpty()?n:rightSt.peek();
            rightSt.push(n-1-i);
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            long positivePart = prePreSum[right[i]+1] - prePreSum[i+1];
            long negativePart = prePreSum[i+1] - prePreSum[left[i]+1];
            ans = (ans + ((((positivePart*(i-left[i]))%mod - (negativePart*(right[i]-i))%mod + mod)%mod) * strength[i])%mod)%mod;
        }
        return (int)ans;
    }
}