class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int found = 0, sign = 0;
        long ans = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                found = 1;
                ans = ans*10 + (ch-'0');
                if(ans>Integer.MAX_VALUE){
                    break;
                }
            }else if(found==1){
                break;
            }else{
                if((ch=='+' || ch=='-') && sign==0){
                    if(ch=='+'){
                        sign = 1;
                    }else{
                        sign = -1;
                    }
                }else{
                    break;
                }
            }
        }
        if(sign!=-1){
            return (int)Math.min(Integer.MAX_VALUE, ans);
        }else{
            return (int)Math.max(Integer.MIN_VALUE, -ans);
        }
    }
}