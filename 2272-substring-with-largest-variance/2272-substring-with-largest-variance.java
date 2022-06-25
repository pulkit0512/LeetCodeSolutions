class Solution {
    public int largestVariance(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int len = rev.length();
        int variance = 0;
        for(char i='a';i<='z';i++){
            for(char j='a';j<='z';j++){
                variance = Math.max(variance, getVariance(s, len, i, j));
                variance = Math.max(variance, getVariance(rev, len, i, j));
            }
        }
        return variance;
    }
    
    private int getVariance(String s, int len, char i, char j) {
        int variance = 0;
        int firstFreq = 0, secondFreq = 0;
        for(int k=0;k<len;k++){
            if(s.charAt(k)==i){
                firstFreq++;
            }else if(s.charAt(k)==j){
                secondFreq++;
            }
                if(firstFreq>0 && secondFreq>0 && firstFreq>secondFreq){
                variance = Math.max(variance, firstFreq-secondFreq);
            }
            if(firstFreq<secondFreq){
                firstFreq = 0;
                secondFreq = 0;
            }
        }
        return variance;
    }
}