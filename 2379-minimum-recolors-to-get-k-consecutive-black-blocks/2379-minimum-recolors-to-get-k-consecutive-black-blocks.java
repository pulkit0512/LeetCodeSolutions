class Solution {
    public int minimumRecolors(String blocks, int k) {
        int len = blocks.length();
        int wCnt = 0;
        
        // Sliding Window
        int ans = k;
        for(int i=0;i<len;i++){
            if(i<k){
                if(blocks.charAt(i)=='W'){
                    wCnt++;
                }
            }else {
                ans = Math.min(ans, wCnt);
                if(blocks.charAt(i)=='W'){
                    wCnt++;
                }
                if(blocks.charAt(i-k)=='W'){
                    wCnt--;
                }
            }
        }
        ans = Math.min(ans, wCnt);
        return ans;
    }
}