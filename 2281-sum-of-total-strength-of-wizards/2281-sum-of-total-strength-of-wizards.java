class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int MOD = 1_000_000_007;
        
        long[] preSum = new long[n + 1];
        long[] preMul = new long[n + 2];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = (preSum[i] + strength[i]) % MOD;
        }
        for (int i = 0; i <= n; i++) {
            preMul[i + 1] = (preMul[i] + preSum[i]) % MOD;
        }
        
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < strength.length; i++) {
            while (!stack.isEmpty() && strength[i] <= strength[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        int[] right = new int[n];
        stack = new ArrayDeque<>();
        for (int i = strength.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && strength[i] < strength[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (((preMul[right[i] + 1] - preMul[i + 1]) * (i - left[i]) % MOD + MOD - (preMul[i + 1] - preMul[left[i] + 1]) * (right[i] - i) % MOD) * strength[i])%MOD;
            ans %= MOD;
        }
        return (int)ans;
    }
}