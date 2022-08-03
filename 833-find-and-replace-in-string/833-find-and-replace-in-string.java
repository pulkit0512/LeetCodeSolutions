class Solution {
    class pair{
        String src, tar;
        pair(String s, String t){
            src = s;
            tar = t;
        }
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, pair> map = new HashMap<>();
        for(int i=0;i<indices.length;i++){
            map.put(indices[i], new pair(sources[i], targets[i]));
        }
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        for(int i=0;i<len;){
            if(map.containsKey(i)){
                if(s.indexOf(map.get(i).src, i)==i){
                    ans.append(map.get(i).tar);
                    i += map.get(i).src.length();
                }else{
                    ans.append(s.charAt(i));
                    i++;
                }
            }else{
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}