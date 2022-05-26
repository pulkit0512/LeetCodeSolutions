class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }
        if(n==Integer.MIN_VALUE) {
            if(x==1.0 || x==-1.0){
                return 1.0;
            }else{
                return 0.0;
            }
        }
        int sign = 1;
        if(n<0) {
            n = -n;
            sign = -1;
        }
        
        double power = calPow(x, n);
        if(sign==-1){
            return 1/power;
        }
        return power;
    }
    
    private double calPow(double x, int n) {
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