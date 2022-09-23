class Solution {
    public int concatenatedBinary(int n) {
        
        //return concatenatedBinaryNLogN(n);
        return concatenatedBinaryN(n);
    }
    
    private int concatenatedBinaryNLogN(int n) {
        int mod = 1000000007;
        
        int ans = 0;
        for(int i=1;i<=n;i++){
            // LogN way to get length of current i.
            int x = i;
            while(x>0){
                x = x/2;
                ans = (ans<<1)%mod;
            }
            
            ans = (ans + i)%mod;
            
        }
        return (int)ans;
    }
    
    private int concatenatedBinaryN(int n) {
        int mod = 1000000007;
        
        long ans = 0;
        int length = 0;
        for(int i=1;i<=n;i++){
            // O(1) way to see if length is same as previous or increased.
            // Length will increase only in case of power of 2.
            if((i&(i-1))==0){
                length++;
            }
            ans = (((ans<<length)%mod) + i)%mod;
            
        }
        return (int)ans;
    }
}