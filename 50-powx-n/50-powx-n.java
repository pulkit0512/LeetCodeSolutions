class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        if(n==1 || x==1){
            return x;
        }
        long val = n;
        int sign = 1;
        if(val<0) {
            val = -val;
            sign = -1;
        }
        
        double power = calPow(x, val);
        if(sign==-1){
            return 1/power;
        }
        return power;
    }
    
    private double calPow(double x, long n) {
        double pow = 1.0;
        while(n>0){
            if(n%2==1){
                pow = pow*x;
                n--;
            }
            x = x*x;
            n = n/2;
        }
        return pow;
    }
}