class Solution {
    public double myPow(double x, int n) {
        if(x==1 || n==1){
            return x;
        }
        
        long val = n;
        if(val<0){
            x = 1/x;
            val = -val;
        }
        
        return calPow(x, val);
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