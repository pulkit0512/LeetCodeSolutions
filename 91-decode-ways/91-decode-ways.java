class Solution {
    public int numDecodings(String s) {
        return numDecodingsNSpace(s);
        //return numDecodingsConstantSpace(s);
    }
    
    private int numDecodingsConstantSpace(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int n = s.length();
        int prev = 1;
        int curr = 1;
        for(int i=1;i<n;i++){
            int val = s.charAt(i)-'0';
            int val1 = s.charAt(i-1)-'0';
            int temp = curr;
            if(val!=0){
                val = val1*10 + val;
                if(val<=26 && val1!=0){
                    curr = curr + prev;
                }
            }else{
                if(val1==0 || val1>2){
                    return 0;
                }
                curr = prev;
            }
            prev = temp;
        }
        return curr;
    }
    
    private int numDecodingsNSpace(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=1;i<n;i++){
            int val = s.charAt(i)-'0';
            int val1 = s.charAt(i-1)-'0';
            if(val!=0){
                val = val1*10 + val;
                if(val<=26 && val1!=0){
                    dp[i+1] = dp[i] + dp[i-1];
                }else{
                    dp[i+1] = dp[i];
                }
            }else{
                if(val1==0 || val1>2){
                    return 0;
                }
                dp[i+1] = dp[i-1];
            }
        }
        return dp[n];
    }
}