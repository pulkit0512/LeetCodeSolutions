class Solution {
    public int lengthOfLongestSubstring(String s) {
        // time complexity O(2N).
        //return lengthOfLongestSubstringUsingSet(s);
        
        // time complexity O(N)
        return lengthOfLongestSubstringUsingMap(s);
    }
    private int lengthOfLongestSubstringUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int ans = 0;
        int st = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                st = Math.max(map.get(ch), st);
            }
            ans = Math.max(ans, i-st+1);
            map.put(ch, i+1);
        }
        return ans;
    }
    private int lengthOfLongestSubstringUsingSet(String s) {
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