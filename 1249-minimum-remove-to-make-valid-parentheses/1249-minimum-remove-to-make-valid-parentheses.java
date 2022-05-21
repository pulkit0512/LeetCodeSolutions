class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int openSeen = 0, balance = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)==')'){
                if(balance==0){
                    continue;
                }else{
                    balance--;
                }
            }else if(s.charAt(i)=='('){
                balance++;
                openSeen++;
            }
            sb.append(s.charAt(i));
        }
        if(balance==0){
            return sb.toString();
        }
        int open = openSeen - balance;
        StringBuilder ans = new StringBuilder();
        len = sb.length();
        for(int i=0;i<len;i++){
            if(sb.charAt(i)=='('){
                open--;
                if(open<0){
                    continue;
                }
            }
            ans.append(sb.charAt(i));
        }
        return ans.toString();
    }
}