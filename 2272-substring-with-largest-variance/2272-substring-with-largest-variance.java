class Solution {
    public int largestVariance(String s) {
        int map[] = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++){
            map[s.charAt(i)-'a']++;
        }
        int variance = 0;
        for(char i='a';i<='z';i++){
            if(map[i-'a']==0){
                continue;
            }
            for(char j='a';j<='z';j++){
                if(map[j-'a']==0 || i==j){
                    continue;
                }
                int firstFreq = 0, secondFreq = 0;
                int secondCount = map[j-'a'];
                for(int k=0;k<len;k++){
                    if(s.charAt(k)==i){
                        firstFreq++;
                    }else if(s.charAt(k)==j){
                        secondFreq++;
                        secondCount--;
                    }
                    if(firstFreq>0 && secondFreq>0 && firstFreq>secondFreq){
                        variance = Math.max(variance, firstFreq-secondFreq);
                    }
                    if(firstFreq<secondFreq && secondCount>0){
                        firstFreq = 0;
                        secondFreq = 0;
                    }
                }
            }
        }
        return variance;
    }
}