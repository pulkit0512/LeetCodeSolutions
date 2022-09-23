class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        
        long ans = 0;
        for(int i=1;i<=n;i++){
            int x = i;
            while(x>0){
                x = x/2;
                ans = (2*ans)%mod;
            }
            
            ans = (ans + i)%mod;
        }
        return (int)ans;
    }
}