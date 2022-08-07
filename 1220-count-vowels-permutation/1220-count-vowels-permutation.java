class Solution {
    public int countVowelPermutation(int n) {
        int[] vowels = new int[5];
        vowels[0] = vowels[1] = vowels[2] = vowels[3] = vowels[4] = 1;
        int mod = 1000000007;
        for(int i=2;i<=n;i++){
            int[] cur = new int[5];
            cur[0] = vowels[1];
            cur[1] = (vowels[0] + vowels[2])%mod;
            cur[2] = ((vowels[0] + vowels[1])%mod + (vowels[3] + vowels[4])%mod)%mod;
            cur[3] = (vowels[2] + vowels[4])%mod;
            cur[4] = vowels[0];
            vowels = cur;
        }
        int ans = 0;
        for(int i=0;i<5;i++){
            ans = (ans + vowels[i])%mod;
        }
        return ans;
    }
}