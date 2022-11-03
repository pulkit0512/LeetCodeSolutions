class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String word:words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int len = 0;
        boolean oddFound = false;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int freq = entry.getValue();
            
            if(word.charAt(0) == word.charAt(1)) {
                if(freq%2==0) {
                    len += 2*freq;
                }else if(!oddFound){
                    len += 2*freq;
                    oddFound = true;
                }else{
                    len += 2*(freq-1);
                }
            }else{
                String rev = word.charAt(1)+""+word.charAt(0);
                if(map.containsKey(rev)) {
                    int freqRev = map.get(rev);
                    len += 4*Math.min(freq, freqRev);
                }
            }
            
            map.put(word, 0);
        }
        
        return len;
    }
}