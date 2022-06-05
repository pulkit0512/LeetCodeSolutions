class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String str:strs){
            int[] freqMap = new int[26];
            int len = str.length();
            for(int i=0;i<len;i++){
                freqMap[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder(52);
            for(int i=0;i<26;i++){
                sb.append(freqMap[i]).append('#');
            }
            String key = sb.toString();
            if(!groups.containsKey(key)){
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}