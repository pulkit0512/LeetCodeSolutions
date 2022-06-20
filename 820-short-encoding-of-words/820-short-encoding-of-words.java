class Solution {
    public int minimumLengthEncoding(String[] words) {
        Map<String, Integer> suffixMap = new HashMap<>();
        for(int idx=0;idx<words.length;idx++){
            int len = words[idx].length();
            String s = "";
            for(int i=len-1;i>=0;i--){
                s += words[idx].charAt(i);
                suffixMap.put(s, suffixMap.getOrDefault(s, 0) + 1);
            }
            words[idx] = s;
        }
        //System.out.println(suffixMap);
        int len = 0;
        for(String word:words){
            if(suffixMap.get(word)==1){
                len += word.length()+1;
            }else{
                suffixMap.put(word, suffixMap.get(word)-1);
            }
        }
        return len;
    }
}