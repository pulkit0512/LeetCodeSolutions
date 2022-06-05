class Solution {
    public int minSwaps(String s) {
        int len = s.length();
        int open = 0, close = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='['){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    close++;
                }
            }
        }
        return (int)Math.ceil((open+close)/4.0);
    }
}