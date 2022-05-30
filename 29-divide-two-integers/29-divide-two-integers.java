class Solution {
    public int divide(int dividend, int divisor) {
        //return divideWhenLongNotAllowed(dividend, divisor);
        return divideWhenLongAllowed(dividend, divisor);
    }
    private int divideWhenLongNotAllowed(int dividend, int divisor) {
        // Special cases: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        
        int neg = 2;
        if(dividend>0){
            neg--;
            dividend = -dividend;
        }
        if(divisor>0){
            neg--;
            divisor = -divisor;
        }
        int maxBit = 0;
        while(divisor >= (Integer.MIN_VALUE >>1) && divisor+divisor >=  dividend) {
            maxBit++;
            divisor += divisor;
        }
        int q = 0;
        for(int i=maxBit;i>=0;i--){
            if(divisor>=dividend) {
                q -= (1<<i);
                dividend -= divisor;
            }
            divisor = (divisor+1)>>1;
        }
        if(neg!=1){
            q = -q;
        }
        return q;
    }
    
    private int divideWhenLongAllowed(int dividend, int divisor) {
        int p=1;
        long divid = dividend, divis = divisor;
        if(divid<0 || divis<0){
            p=-1;
        }
        if(divid<0 && divis<0){
            p=1;
        }
        divid = Math.abs(divid);
        divis = Math.abs(divis);
        long q = 0, r = 0;
        for(int i=31;i>=0;i--){
            if(r+(divis<<i) <= divid){
                r = r + (divis<<i);
                q = q | (1L<<i);
            }
        }
        if(p==1 && q>Integer.MAX_VALUE){
            q = Integer.MAX_VALUE;
        }
        if(p<1){
            return (int)(-q);
        }
        return (int)q;
    }
}