class Solution {
    public int minAddToMakeValid(String s) {
        int len = s.length();
        int open = 0, close = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    close++;
                }
            }
        }
        return open+close;
    }
}