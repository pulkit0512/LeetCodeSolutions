class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int st = 0, ed = n;
        int idx = 0;
        int ans[] = new int[n+1];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I'){
                ans[idx++] = st++;
            }else{
                ans[idx++] = ed--;
            }
        }
        ans[n] = st;
        return ans;
    }
}