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
                if(prevChar=='L' && curChar=='R'){
                    
                }else if(prevChar=='L' && curChar=='L'){
                    fillAns(ans, prevIdx+1, i, prevChar);
                }else if(prevChar=='R' && curChar=='R'){
                    fillAns(ans, prevIdx+1, i, prevChar);
                }else{
                    int cnt = i-prevIdx-1;
                    int half = cnt/2;
                    fillAns(ans, prevIdx+1, prevIdx+1+half, prevChar);
                    fillAns(ans, i-half, i, curChar);
                }
                prevChar = curChar;
                prevIdx = i;
            }
        }
        
        curChar = 'R';
        if(prevChar=='L' && curChar=='R'){
            
        }else if(prevChar=='L' && curChar=='L'){
            fillAns(ans, prevIdx+1, len, prevChar);
        }else if(prevChar=='R' && curChar=='R'){
            fillAns(ans, prevIdx+1, len, prevChar);
        }else{
            int cnt = len-prevIdx-1;
            int half = cnt/2;
            fillAns(ans, prevIdx+1, prevIdx+1+half, prevChar);
            fillAns(ans, len-half, len, curChar);
        }
        
        return String.valueOf(ans);
    }
    
    private void fillAns(char[] ans, int l, int r, char ch) {
        for(int i=l;i<r;i++){
            ans[i] = ch;
        }
    }
}