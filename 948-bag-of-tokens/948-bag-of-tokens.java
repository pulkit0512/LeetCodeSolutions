class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int n = tokens.length;
        int i = 0, j = n-1;
        
        int curScore = 0;
        int maxScore = 0;
        
        while(i<=j) {
            if(tokens[i]<=power) {
                curScore++;
                power -= tokens[i];
                maxScore = Math.max(maxScore, curScore);
                i++;
            }else if(curScore>=1){
                curScore--;
                power += tokens[j];
                j--;
            }else{
                break;
            }
        }
        return maxScore;
    }
}