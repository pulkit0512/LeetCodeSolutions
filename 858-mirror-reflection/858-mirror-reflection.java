class Solution {
    public int mirrorReflection(int p, int q) {
        if(p%q!=0){
            while(p%2==0 && q%2==0){
                p = p/2;
                q = q/2;
            }
            if(p%2==1 && q%2==1){
                return 1;
            }else if(p%2==1 && q%2==0){
                return 0;
            }else{
                return 2;
            }
        }else{
            if((p/q)%2==1){
                return 1;
            }else{
                return 2;
            }
        }
    }
}