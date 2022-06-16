class Solution {
    public int numTilings(int n) {
        //return numTilingsTransitionSeries(n);
        return numTilingsUsingFullAndPartialBoardConcept(n);
    }
    
    private int numTilingsUsingFullAndPartialBoardConcept(int n){
        if(n<=2){
            return n;
        }
        int fPrev = 1, fCurr = 2;
        int pCurr = 1;
        int mod = 1000000007;
        for(int i=3;i<=n;i++){
            int val = fCurr;
            fCurr = ((fCurr + fPrev)%mod + (2*pCurr)%mod)%mod;
            pCurr = (pCurr + fPrev)%mod;
            fPrev = val;
        }
        return fCurr;
    }
    
    private int numTilingsTransitionSeries(int n) {
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