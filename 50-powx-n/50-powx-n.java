class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        if(x==1 || n==1){
            return x;
        }
        
        long val = n;
        int sign = 1;
        if(val<0){
            sign = -1;
            val = -val;
        }
        
        double pow = calPow(x, val);
        
        if(sign==-1){
            return 1/pow;
        }else{
            return pow;
        }
    }
    
    private double calPow(double x, long n) {
        double res = 1.0;
        while(n>0){
            if(n%2==1){
                res = res*x;
                n--;
            }
            x = x*x;
            n = n/2;
        }
        return res;
    }
}