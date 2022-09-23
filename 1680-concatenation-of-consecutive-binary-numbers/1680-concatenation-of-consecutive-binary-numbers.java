class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        
        long ans = 0;
        for(int i=1;i<=n;i++){
            String binary = Integer.toBinaryString(i);
            int len = binary.length();
            for(int j=0;j<len;j++){
                ans = (2*ans + (binary.charAt(j)-'0'))%mod;
            }
        }
        return (int)ans;
    }
}