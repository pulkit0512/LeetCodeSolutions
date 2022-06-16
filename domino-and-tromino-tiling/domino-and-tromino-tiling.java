class Solution {
    public int numTilings(int n) {
        if(n<=2){
            return n;
        }
        int three_back = 1, two_back = 1, one_back = 2;
        int mod = 1000000007;
        for(int i=3;i<=n;i++){
            int val = ((2*one_back)%mod + three_back)%mod;
            three_back = two_back;
            two_back = one_back;
            one_back = val;
        }
        return one_back;
    }
}