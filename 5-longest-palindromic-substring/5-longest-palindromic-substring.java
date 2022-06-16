class Solution {
    public String longestPalindrome(String s) {
        // O(N*N) space complexity, O(N*N) time complexity
        // return longestPalindromeN2Space(s);
        
        // O(1) space complexity optimized, O(N*N) time complexity
        return longestPalindrome1Space(s);
    }
    private String longestPalindrome1Space(String s) {
        int n = s.length();
        if(n<=1){
            return s;
        }
        int maxLen = 1, start = 0;
        for(int i=1;i<n;i++){
            
            //find largest even palindromic substring with i-1 & i as centre.
            int low = i-1, high = i;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }
            low++;
            high--;
            if(s.charAt(low)==s.charAt(high) && (high-low+1)>maxLen){
                start = low;
                maxLen = high-low+1;
            }
            
            //find largest odd palindromic substring with i as centre
            low = i-1;
            high = i+1;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }
            low++;
            high--;
            if(s.charAt(low)==s.charAt(high) && (high-low+1)>maxLen){
                start = low;
                maxLen = high-low+1;
            }
        }
        return s.substring(start, start+maxLen);
    }
    
    private String longestPalindromeN2Space(String s) {
        int n = s.length();
        int x = 0, y = 0;
        boolean dp[][] = new boolean[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0, j=gap;j<n;i++,j++){
                if(i==j){
                    dp[i][j] = true;
                    x = i;
                    y = j;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                        x = i;
                        y = j;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        return s.substring(x, y+1);
    }
}