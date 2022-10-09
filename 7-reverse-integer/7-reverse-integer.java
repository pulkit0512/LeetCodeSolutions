class Solution {
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE) {
            return 0;
        }
        
        int sign = (x<0)?-1:1;
        x = sign*x;
        int val = 0;
        while(x>0){
            if(val>Integer.MAX_VALUE/10 || (val==Integer.MAX_VALUE/10 && (x%10)>7)){
                return 0;
            }
            val = val*10 + x%10;
            x=x/10;
        }
        
        return sign*val;
    }
}