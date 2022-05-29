class Solution {
    public int maxProduct(String[] words) {
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