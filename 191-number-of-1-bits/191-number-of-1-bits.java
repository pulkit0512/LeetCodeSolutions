public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int x = n;
        int oneBits = 0;
        while(x!=0){
            x = x&(x-1);
            oneBits++;
        }
        return oneBits;
    }
}