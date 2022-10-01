class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        
        int oneBack = 1, twoBack = 1;
        int len = s.length();
        for(int i=1;i<len;i++){
            int cur = 0;
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0'){
                    return 0;
                }
                
                if(s.charAt(i-1)<='2'){
                    cur += twoBack;
                }
            }else{
                cur += oneBack;
                if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6')){
                    cur += twoBack;
                }
            }
            twoBack = oneBack;
            oneBack = cur;
        }
        
        return oneBack;
    }
}