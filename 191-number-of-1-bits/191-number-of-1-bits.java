public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long x = Integer.toUnsignedLong(n);
        int cnt = 0;
        while(x>0){
            x=x&(x-1);
            cnt++;
        }
        return cnt;
    }
}