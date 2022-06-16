class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int max = n*k;
        if(target<n || target>max){
            return 0;
        }
        int mod = 1000000007;
        int dpPrev[] = new int[target+1];
        int dpCurr[] = new int[target+1];
        for(int i=1;i<=Math.min(k,target);i++){
            dpPrev[i] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=i;j<=target;j++){
                if(j<=k){
                    dpCurr[j] = (dpCurr[j-1] + dpPrev[j-1])%mod;
                }else{
                    dpCurr[j] = ((dpCurr[j-1] + dpPrev[j-1])%mod - dpPrev[j-(k+1)])%mod;
                    if(dpCurr[j]<0){
                        dpCurr[j] = (dpCurr[j] + mod)%mod;
                    }
                }
            }
            for(int j=1;j<=target;j++){
                dpPrev[j] = dpCurr[j];
                dpCurr[j] = 0;
            }
        }
        return dpPrev[target];
    }
}