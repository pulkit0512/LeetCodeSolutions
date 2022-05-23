class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int st = 0, ans = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                ans = Math.max(ans, i-st);
                while(s.charAt(st)!=ch){
                    set.remove(s.charAt(st));
                    st++;
                }
                st++;
            }
        }
        ans = Math.max(ans, len-st);
        return ans;
    }
}