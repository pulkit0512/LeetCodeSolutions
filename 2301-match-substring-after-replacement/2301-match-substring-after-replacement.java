class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for(char[] mapping:mappings){
            if(!map.containsKey(mapping[0])){
                map.put(mapping[0], new HashSet<>());
            }
            map.get(mapping[0]).add(mapping[1]);
        }
        int sLen = s.length();
        int subLen = sub.length();
        int st = 0;
        List<Integer> index = new ArrayList<>();
        for(int i=0;i<sLen;i++){
            if(s.charAt(i)==sub.charAt(0)){
                index.add(i);
            }else if(map.containsKey(sub.charAt(0)) && map.get(sub.charAt(0)).contains(s.charAt(i))){
                index.add(i);
            }
        }
        //System.out.println(index);
        for(int i=0;i<index.size();i++){
            int j = 0;
            int k = index.get(i);
            for(;j<subLen && k<sLen;j++,k++){
                //System.out.println(j+" "+k);
                if(sub.charAt(j)==s.charAt(k)){
                    continue;
                }else if(map.containsKey(sub.charAt(j)) && map.get(sub.charAt(j)).contains(s.charAt(k))){
                    continue;
                }else{
                    break;
                }
            }
            if(j==subLen){
                return true;
            }
        }
        return false;
    }
}