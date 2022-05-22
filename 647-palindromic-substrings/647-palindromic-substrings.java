class Solution {
    public int countSubstrings(String s) {
        //return countSubstringsN2Space(s);
        return countSubstringsConstantSpace(s);
    }
    
    private int countSubstringsConstantSpace(String s){
        int len = s.length();
        int ans = len;
        for(int i=1;i<len;i++){
            //find Even Palindrome
            int x = i-1, y = i;
            while(x>=0 && y<len){
                if(s.charAt(x)==s.charAt(y)){
                    x--;
                    y++;
                    ans++;
                }else{
                    break;
                }
            }
            
            //find odd Palindrome
            x = i-1;
            y = i+1;
            while(x>=0 && y<len){
                if(s.charAt(x)==s.charAt(y)){
                    x--;
                    y++;
                    ans++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
    
    private int countSubstringsN2Space(String s){
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int ans = 0;
        for(int gap=0;gap<len;gap++){
            for(int i=0,j=gap;i<len && j<len;i++,j++){
                if(gap==0){
                    dp[i][j] = true;
                    ans++;
                }else{
                    if(s.charAt(i)==s.charAt(j) && ((i+1)==j || dp[i+1][j-1])){
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}