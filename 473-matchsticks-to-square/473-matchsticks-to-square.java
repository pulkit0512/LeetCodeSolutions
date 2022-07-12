class Solution {
    int possibleLen;
    int k;
    Map<Integer, Boolean> memo;
    public boolean makesquare(int[] matchsticks) {
        int totalLength = 0;
        int n = matchsticks.length;
        for(int match:matchsticks){
            totalLength += match;
        }
        if(totalLength%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);
        for(int i=0;i<n/2;i++){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[n-1-i];
            matchsticks[n-1-i] = temp;
        }
        possibleLen = totalLength/4;
        k = 4;
        memo = new HashMap<>();
        return backtrack(matchsticks, 0, 0, 0, 0);
    }
    
    private boolean backtrack(int[] matchsticks, int idx, int count, int curLen, int mask){
        if(count==k-1){
            return true;
        }
        if(curLen>possibleLen){
            return false;
        }
        if(memo.containsKey(mask)){
            return memo.get(mask);
        }
        if(curLen == possibleLen){
            boolean isPossible = backtrack(matchsticks, 0, count+1, 0, mask);
            memo.put(mask, isPossible);
            return isPossible;
        }
        for(int i=idx;i<matchsticks.length;i++){
            if(((mask>>i)&1)==0){
                mask = mask | (1<<i);
                boolean isPossible = backtrack(matchsticks, i+1, count, curLen + matchsticks[i], mask);
                if(isPossible){
                    memo.put(mask, true);
                    return true;
                }
                mask = mask ^ (1<<i);
            }
        }
        memo.put(mask, false);
        return false;
    }
}