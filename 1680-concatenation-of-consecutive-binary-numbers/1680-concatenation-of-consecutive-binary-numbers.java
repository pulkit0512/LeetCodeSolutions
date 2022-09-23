class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        
        long ans = 0;
        for(int i=1;i<=n;i++){
            int x = i;
            int msb = 0;
            while(x>0){
                x = x/2;
                msb++;
            }
            
            ans = ((ans*(1<<msb))%mod + i)%mod;
        }
        return (int)ans;
    }
}