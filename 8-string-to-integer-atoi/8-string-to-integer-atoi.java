class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int found = 0, sign = 0;
        int ans = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                found = 1;
                if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && (ch-'0')>(Integer.MAX_VALUE%10))){
                    return (sign==-1)?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                ans = ans*10 + (ch-'0');
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
            return ans;
        }else{
            return -ans;
        }
    }
}