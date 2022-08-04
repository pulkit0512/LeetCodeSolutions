class Solution {
    public int reverse(int x) {
        int sign = (x<0)?-1:1;
        x = sign*x;
        int rev = 0;
        int max = Integer.MAX_VALUE;
        while(x>0){
            if(rev>max/10 || (rev==max/10 && x%10>7)){
                return 0;
            }
            rev = rev*10 + x%10;
            x = x/10;
        }
        if(sign==-1){
            return -rev;
        }else{
            return rev;
        }
    }
}