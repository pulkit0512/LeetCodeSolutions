class Solution {
    public int secondsToRemoveOccurrences(String s) {
        /*int ans = 0;
        while(s.contains("01")){
            s = s.replace("01", "10");
            ans++;
        }
        return ans;*/
        
        int len = s.length();
        int ans = 0;
        int cnt1 = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='1') {
                if(i==cnt1){
                    cnt1++;
                    continue;
                }else if(i-cnt1<=ans){
                    ans++;
                }else{
                    ans = i-cnt1;
                }
                cnt1++;
            }
        }
        return ans;
    }
}