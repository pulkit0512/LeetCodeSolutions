class Solution {
    String s1, s2, s3;
    int len1, len2, len3;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.len1 = s1.length();
        this.len2 = s2.length();
        this.len3 = s3.length();
        if(len1+len2!=len3){
            return false;
        }
        
        //return isInterleaveMemoization(0, 0, new Boolean[len1+1][len2+1]);
        //return isInterleave2DTabulation();
        return isInterleave1DTabulation();
    }
    
    private boolean isInterleave1DTabulation() {
        boolean prevDp[] = new boolean[len2+1];
        boolean currDp[] = new boolean[len2+1];
        prevDp[0] = true;
        for(int j=1;j<=len2;j++){
            if(s2.charAt(j-1)==s3.charAt(j-1)){
                prevDp[j] = true;
            }else{
                break;
            }
        }
        for(int i=1;i<=len1;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)){
                currDp[0] = prevDp[0];
            }
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                    currDp[j] = prevDp[j];
                    if(currDp[j]){
                        continue;
                    }
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-1)){
                    currDp[j] = currDp[j-1];
                }
            }
            for(int j=0;j<=len2;j++){
                prevDp[j] = currDp[j];
                currDp[j] = false;
            }
        }
        return prevDp[len2];
    }
    
    private boolean isInterleave2DTabulation() {
        boolean dp[][] = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=1;i<=len1;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0] = true;
            }else{
                break;
            }
        }
        for(int j=1;j<=len2;j++){
            if(s2.charAt(j-1)==s3.charAt(j-1)){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j] = dp[i-1][j];
                    if(dp[i][j]){
                        continue;
                    }
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
    
    private Boolean isInterleaveMemoization(int i, int j, Boolean[][] dp){
        if(i==len1 && j==len2){
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(i<len1 && s1.charAt(i)==s3.charAt(i+j)){
            if(isInterleaveMemoization(i+1, j, dp)){
                dp[i][j] = true;
                return true;
            }
        }
        if(j<len2 && s2.charAt(j)==s3.charAt(i+j)){
            if(isInterleaveMemoization(i, j+1, dp)){
                dp[i][j] = true;
                return true;
            }
        }
        dp[i][j] = false;
        return false;
    }
}