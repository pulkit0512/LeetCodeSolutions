class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        // Open to keep track of unbalanced open brackets.
        // Close to keep track of unbalanced close brackets.
        int open = 0, close = 0;
        int ans = 0;
        while(close<len){
            if(s.charAt(close)=='('){
                // increment count of open brackets.
                open++;
            }else{
                // If reached to end or next char is not close bracket.
                // so we only get one close bracket. Need to insert one ')' in the String.
                if(close+1 == len || s.charAt(close+1)!=')'){
                    ans++;
                }else{
                    // found both the close brackets.
                    close++;
                }
                // Found both close brackets if we don't have any open bracket before we need to insert 1 open bracket.
                if(open==0){
                    ans++;
                }else{
                    // Else balance out open bracket.
                    open--;
                }
            }
            close++;
        }
        // Any open brackets still left and 2*open number of close brackets.
        return ans + 2*open;
    }
}