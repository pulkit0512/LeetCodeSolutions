class Solution {
    public String decodeAtIndex(String s, int k) {
        long orgLen = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                orgLen = orgLen * (s.charAt(i)-'0');
            }else{
                orgLen++;
            }
        }
        int idx = -1;
        for(int i=len-1;i>=0;i--){
            if(Character.isDigit(s.charAt(i))){
                orgLen = orgLen/(s.charAt(i)-'0');
                k %= orgLen;
            }else{
                if(k%orgLen==0){
                    idx = i;
                    break;
                }
                orgLen--;
            }
        }
        return s.charAt(idx)+"";
    }
}