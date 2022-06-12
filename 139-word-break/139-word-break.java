class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<Integer> index = new ArrayList<>();
        int st = 0;
        int len = s.length();
        for(int i=1;i<=len;i++){
            String sub = s.substring(st, i);
            if(wordSet.contains(sub)){
                index.add(st);
                st = i;
            }else{
                for(int j=0;j<index.size();j++){
                    if(wordSet.contains(s.substring(index.get(j), i))){
                        index.add(st);
                        st = i;
                        break;
                    }
                }
            }
        }
        return st==len;
    }
}