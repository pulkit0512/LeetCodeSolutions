class Solution {
    // Solves the purpose but gives TLE on larger data
    /*public List<List<String>> wordSquares(String[] words) {
        int strLen = words[0].length();
        List<List<String>> ans = new ArrayList<>();
        helper(words, strLen, ans, new ArrayList<>());
        return ans;
    }
    private void helper(String[] words, int strLen, List<List<String>> ans, List<String> temp){
        if(temp.size()==strLen){
            boolean found = true;
            for(int i=0;i<strLen;i++){
                for(int j=i+1;j<strLen;j++){
                    if(temp.get(i).charAt(j)!=temp.get(j).charAt(i)){
                        found = false;
                        break;
                    }
                }
                if(!found){
                    break;
                }
            }
            if(found){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=0;i<words.length;i++){
            temp.add(words[i]);
            helper(words, strLen, ans, temp);
            temp.remove(temp.size()-1);
        }
    }*/
    Map<String, List<String>> prefixMap;
    int strLen;
    List<List<String>> ans;
    public List<List<String>> wordSquares(String[] words) {
        strLen = words[0].length();
        prefixMap = getPrefixMap(words);
        ans = new ArrayList<>();
        List<String> square = new ArrayList<>();
        for(String word:words){
            square.add(word);
            getSquare(1, square);
            square.remove(square.size()-1);
        }
        return ans;
    }
    
    private void getSquare(int step, List<String> square) {
        if(step==strLen){
            ans.add(new ArrayList<>(square));
            return;
        }
        
        StringBuilder preStr = new StringBuilder();
        for(int i=0;i<square.size();i++){
            preStr.append(square.get(i).charAt(step));
        }
        
        List<String> prefixes = prefixMap.get(preStr.toString());
        if(prefixes==null){
            return;
        }
        for(String pre:prefixes){
            square.add(pre);
            getSquare(step+1, square);
            square.remove(square.size()-1);
        }
    }
    
    private Map<String, List<String>> getPrefixMap(String[] words) {
        Map<String, List<String>> pMap = new HashMap<>();
        for(String word:words){
            for(int i=1;i<strLen;i++){
                String subStr = word.substring(0, i);
                if(!pMap.containsKey(subStr)){
                    pMap.put(subStr, new ArrayList<>());
                }
                pMap.get(subStr).add(word);
            }
        }
        return pMap;
    }
    
}