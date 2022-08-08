class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String str:strs){
            int[] freqMap = new int[26];
            int len = str.length();
            for(int i=0;i<len;i++){
                freqMap[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(freqMap[i]).append("#");
            }
            String s = sb.toString();
            if(!groups.containsKey(s)){
                groups.put(s, new ArrayList<>());
            }
            groups.get(s).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}