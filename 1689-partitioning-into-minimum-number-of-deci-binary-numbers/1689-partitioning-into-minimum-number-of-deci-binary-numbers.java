class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        int len = n.length();
        for(int i=0;i<len;i++){
            ans = Math.max(ans, n.charAt(i)-'0');
        }
        return ans;
    }
}