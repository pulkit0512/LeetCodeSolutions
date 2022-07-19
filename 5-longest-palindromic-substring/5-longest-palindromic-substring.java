class Solution {
    public String longestPalindrome(String s) {
        // O(N*N) space complexity, O(N*N) time complexity
        // return longestPalindromeN2Space(s);
        
        // O(1) space complexity optimized, O(N*N) time complexity
        return longestPalindrome1Space(s);
    }
    private String longestPalindrome1Space(String s) {
        int len = s.length();
        int st = 0, maxLen = 1;
        for(int i=1;i<len;i++){
            int ptr1 = i-1, ptr2 = i;
            while(ptr1>=0 && ptr2<len){
                if(s.charAt(ptr1)==s.charAt(ptr2)){
                    ptr1--;
                    ptr2++;
                }else{
                    break;
                }
            }
            ptr1++;
            ptr2--;
            if(s.charAt(ptr1)==s.charAt(ptr2) && maxLen<ptr2-ptr1+1){
                maxLen = ptr2 - ptr1 + 1;
                st = ptr1;
            }
            
            ptr1 = i-1;
            ptr2 = i+1;
            while(ptr1>=0 && ptr2<len){
                if(s.charAt(ptr1)==s.charAt(ptr2)){
                    ptr1--;
                    ptr2++;
                }else{
                    break;
                }
            }
            ptr1++;
            ptr2--;
            if(s.charAt(ptr1)==s.charAt(ptr2) && maxLen<ptr2-ptr1+1){
                maxLen = ptr2 - ptr1 + 1;
                st = ptr1;
            }
        }
        return s.substring(st, st+maxLen);
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