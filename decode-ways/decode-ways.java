class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int len = s.length();
        int one_back = 1, two_back = 1;
        for(int i=1;i<len;i++){
            int curr = 0;
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0'){
                    return 0;
                }
                if(s.charAt(i-1)<='2'){
                    curr += two_back;
                }
            }else{
                curr += one_back;
                if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6')){
                    curr += two_back;
                }
            }
            two_back = one_back;
            one_back = curr;
        }
        return one_back;
    }
}