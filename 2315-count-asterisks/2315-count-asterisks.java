class Solution {
    public int countAsterisks(String s) {
        int ans = 0;
        int bar = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch=='|'){
                bar++;
            }else if(ch=='*' && bar%2==0){
                ans++;
            }
        }
        return ans;
    }
}