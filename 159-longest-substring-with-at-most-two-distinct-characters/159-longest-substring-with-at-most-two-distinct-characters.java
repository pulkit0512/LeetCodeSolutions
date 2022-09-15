class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int ans = 0;
        int st = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                if(map.size()==2){
                    ans = Math.max(ans, i-st);
                    
                    while(map.size()==2){
                        char cur = s.charAt(st);
                        int k = map.get(cur);
                        if(k==1){
                            map.remove(cur);
                        }else{
                            map.put(cur, k-1);
                        }
                        st++;
                    }
                }
                map.put(ch, 1);
            }
        }
        
        return Math.max(ans, len-st);
    }
}