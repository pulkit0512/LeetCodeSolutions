class Solution {
    public long distinctNames(String[] ideas) {
        List<String>[] preWord = new ArrayList[26];
        for(int i=0;i<26;i++){
            preWord[i] = new ArrayList<>();
        }
        for(String idea:ideas){
            String sub = idea.substring(1);
            preWord[idea.charAt(0)-'a'].add(sub);
        }
        long ans = 0;
        for(int i=0;i<26;i++){
            if(preWord[i].isEmpty()){
                continue;
            }
            for(int j=i+1;j<26;j++){
                if(preWord[j].isEmpty()){
                    continue;
                }
                Set<String> set = new HashSet<>();
                set.addAll(preWord[i]);
                set.addAll(preWord[j]);
                
                ans += (set.size()-preWord[i].size())*(set.size()-preWord[j].size());
            }
        }
        return 2*ans;
    }
}