class Solution {
    public int shortestWay(String source, String target) {
        int ans = 0;
        int sLen = source.length();
        int tLen = target.length();
        for(int i=0;i<tLen;){
            ans++;
            int prev = i;
            for(int j=0;j<sLen;j++){
                if(target.charAt(i)==source.charAt(j)){
                    i++;
                }
                if(i==tLen){
                    break;
                }
            }
            if(i==prev){
                return -1;
            }
        }
        return ans;
    }
}