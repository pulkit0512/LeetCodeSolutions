class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        // Open to keep track of unbalanced open brackets.
        int open = 0, idx = 0;
        int ans = 0;
        while(idx<len){
            if(s.charAt(idx)=='('){
                // increment count of open brackets.
                open++;
            }else{
                // If reached to end or next char is not close bracket.
                // so we only get one close bracket. Need to insert one ')' in the String.
                if(idx+1 == len || s.charAt(idx+1)!=')'){
                    ans++;
                }else{
                    // found both the close brackets.
                    idx++;
                }
                // Found both close brackets if we don't have any open bracket before we need to insert 1 open bracket.
                if(open==0){
                    ans++;
                }else{
                    // Else balance out open bracket.
                    open--;
                }
            }
            idx++;
        }
        // Any open brackets still left and 2*open number of close brackets.
        return ans + 2*open;
    }
}