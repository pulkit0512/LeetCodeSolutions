class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int max = 0;
        for(int d:deck){
            max = Math.max(max, d);
        }
        int[] fMap = new int[max+1];
        for(int d:deck) {
            fMap[d]++;
        }
        int gcd = getGcd(fMap);
        return gcd>=2?true:false;
    }
    
    private int getGcd(int[] fMap) {
        int result = -1;
        for(int i=0;i<fMap.length;i++){
            if(fMap[i]!=0){
                if(result==-1){
                    result = fMap[i];
                }else{
                    result = gcd(result, fMap[i]);
                }
            }
        }
        return result;
    }
    
    private int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}