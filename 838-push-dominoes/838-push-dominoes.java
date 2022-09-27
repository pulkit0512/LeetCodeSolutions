class Solution {
    public String pushDominoes(String dominoes) {
        char prevChar = 'L';
        int prevIdx = -1;
        int len = dominoes.length();
        char[] ans = new char[len];
        Arrays.fill(ans, '.');
        char curChar;
        for(int i=0;i<len;i++){
            curChar = dominoes.charAt(i);
            if(curChar!='.'){
                ans[i] = curChar;
                handleLRCases(prevChar, curChar, prevIdx, i, ans);
                prevChar = curChar;
                prevIdx = i;
            }
        }
        
        handleLRCases(prevChar, 'R', prevIdx, len, ans);
        
        return String.valueOf(ans);
    }
    
    private void handleLRCases(char prevChar, char curChar, int prevIdx, int curIdx, char[] ans) {
        if(prevChar=='L' && curChar=='L'){
            fillAns(ans, prevIdx+1, curIdx-1, prevChar);
        }else if(prevChar=='R' && curChar=='R'){
            fillAns(ans, prevIdx+1, curIdx-1, prevChar);
        }else if(prevChar=='R' && curChar=='L'){
            int cnt = curIdx-prevIdx-1;
            int half = cnt/2;
            fillAns(ans, prevIdx+1, prevIdx+half, prevChar);
            fillAns(ans, curIdx-half, curIdx-1, curChar);
        }
    }
    
    private void fillAns(char[] ans, int l, int r, char ch) {
        for(int i=l;i<=r;i++){
            ans[i] = ch;
        }
    }
}