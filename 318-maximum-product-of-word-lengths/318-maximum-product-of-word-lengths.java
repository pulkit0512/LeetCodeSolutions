class Solution {
    public int maxProduct(String[] words) {
        //return maxProductUsingListOfSet(words);
        return maxProductUsingBitmaskAndMap(words);
    }
    
    private int maxProductUsingBitmaskAndMap(String[] words) {
        Map<Integer, Integer> preCompute = new HashMap<>();
        for(String word:words) {
            int len = word.length();
            int bitMask = 0;
            for(int i=0;i<len;i++){
                bitMask = bitMask | (1<<(word.charAt(i)-'a'));
            }
            if(!preCompute.containsKey(bitMask)){
                preCompute.put(bitMask, len);
            }else{
                preCompute.put(bitMask, Math.max(preCompute.get(bitMask), len));
            }
        }
        int ans = 0;
        for(int word1:preCompute.keySet()){
            for(int word2:preCompute.keySet()){
                if((word1&word2) == 0){
                    ans = Math.max(ans, preCompute.get(word1)*preCompute.get(word2));
                }
            }
        }
        return ans;
    }
    
    private int maxProductUsingListOfSet(String[] words) {
        int n = words.length;
        List<HashSet<Character>> charset = new ArrayList<>();
        int len[] = new int[n];
        for(int i=0;i<n;i++){
            len[i] = words[i].length();
            charset.add(new HashSet<>());
            for(int j=0;j<len[i];j++){
                charset.get(i).add(words[i].charAt(j));
            }
        }
        //System.out.println(charset);
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                boolean common = false;
                for(char x:charset.get(i)){
                    if(charset.get(j).contains(x)){
                        common = true;
                        break;
                    }
                }
                if(common){
                    continue;
                }
                for(char x:charset.get(j)){
                    if(charset.get(i).contains(x)){
                        common = true;
                        break;
                    }
                }
                if(common){
                    continue;
                }
                ans = Math.max(ans, len[i]*len[j]);
            }
        }
        return ans;
    }
}