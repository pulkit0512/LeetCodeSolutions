class Solution {
    public int secondsToRemoveOccurrences(String s) {
        /*
        int ans = 0;
        while(s.contains("01")){
            s = s.replace("01", "10");
            ans++;
        }
        return ans;
        */
        
        // We need to move all the one's to the right.
        int len = s.length();
        int ans = 0;
        int cnt1 = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='1') {
                if(i==cnt1){ // If current 1 is on right possition continue.
                    cnt1++;
                    continue;
                }else if(i-cnt1<=ans){ // If time needed to move current 1 to required position is less then
                    ans++; // time we have spent then simply in next second it will reach it's position
                }else{
                    // Time needed for current 1 to reach it's required position will be equal to
                    // current index - right index.
                    ans = i-cnt1;
                }
                cnt1++;
            }
        }
        return ans;
    }
}