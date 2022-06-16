class Solution {
    public int countVowelPermutation(int n) {
        long prevA = 1, prevE = 1, prevI = 1, prevO = 1, prevU = 1;
        long currA = 0, currE = 0, currI = 0, currO = 0, currU = 0;
        long mod = 1000000007;
        for(int i=2;i<=n;i++){
            currA = prevE;
            currE = (prevA + prevI)%mod;
            currI = (prevA + prevE + prevO + prevU)%mod;
            currO = (prevI + prevU)%mod;
            currU = prevA;
            
            prevA = currA;
            prevE = currE;
            prevI = currI;
            prevU = currU;
            prevO = currO;
        }
        return (int)((prevA + prevE + prevI + prevO + prevU)%mod);
    }
}