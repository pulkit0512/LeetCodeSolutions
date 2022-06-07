class Solution {
    public boolean confusingNumber(int n) {
        int val = 0, old = n;
        while(n>0){
            int mod = n%10;
            if(mod!=0 && mod!=1 && mod!=6 && mod!=8 && mod!=9){
                return false;
            }
            if(mod==6){
                val = val*10 + 9;
            }else if(mod==9){
                val = val*10 + 6;
            }else{
                val = val*10 + mod;
            }
            n = n/10;
        }
        
        return val!=old;
    }
}