class Solution {
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> outDeg = new HashMap<>();
        Map<Character, Integer> inDeg = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        int n = words.length;
        int len[] = new int[n];
        for(int i=0;i<n;i++){
            len[i] = words[i].length();
            for(int j=0;j<len[i];j++){
                if(!inDeg.containsKey(words[i].charAt(j))){
                    inDeg.put(words[i].charAt(j), 0);
                    outDeg.put(words[i].charAt(j), new HashSet<>());
                }
            }
        }
        for(int i=0;i<n-1;i++){
            int x = Math.min(len[i], len[i+1]);
            for(int j=0;j<x;j++){
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    if(!outDeg.get(words[i].charAt(j)).contains(words[i+1].charAt(j))){
                        int k = inDeg.get(words[i+1].charAt(j));
                        inDeg.put(words[i+1].charAt(j), k+1);
                        outDeg.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                    }
                    break;
                }
                if(j==x-1 && x==len[i+1] && x<len[i]){
                    return "";
                }
            }
        }
        //System.out.println(outDeg);
        //System.out.println(inDeg);
        Queue<Character> que = new LinkedList<>();
        for(char ch:inDeg.keySet()){
            if(inDeg.get(ch)==0){
                que.add(ch);
            }
        }
        while(!que.isEmpty()){
            char temp = que.poll();
            inDeg.remove(temp);
            ans.append(temp);
            for(char ch:outDeg.get(temp)){
                int k = inDeg.get(ch);
                inDeg.put(ch, k-1);
                if(k==1){
                    que.add(ch);
                }
            }
        }
        if(ans.length()!=outDeg.size()){
            return "";
        }
        return ans.toString();
    }
}