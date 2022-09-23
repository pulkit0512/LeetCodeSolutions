class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        
        long ans = 0;
        int length = 0;
        for(int i=1;i<=n;i++){
            /*int x = i;
            while(x>0){
                x = x/2;
                ans = (ans<<1)%mod;
            }*/
            if((i&(i-1))==0){
                length++;
            }
            ans = (((ans<<length)%mod) + i)%mod;
            
            //ans = (ans + i)%mod;
        }
        return (int)ans;
    }
}