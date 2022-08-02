class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int ans = 0, st = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(freq.containsKey(ch)){
                freq.put(ch, freq.get(ch)+1);
            } else{
                if(freq.size()==2){
                    ans = Math.max(ans, i-st);
                }
                while(freq.size()==2){
                    char temp = s.charAt(st);
                    int k = freq.get(temp);
                    if(k==1){
                        freq.remove(temp);
                    }else{
                        freq.put(temp, k-1);
                    }
                    st++;
                }
                freq.put(ch, 1);
            }
        }
        ans = Math.max(ans, len-st);
        return ans;
    }
}