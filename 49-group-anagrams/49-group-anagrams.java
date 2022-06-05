class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for(String str:strs){
            Map<Character, Integer> freqMap = new HashMap<>();
            int len = str.length();
            for(int i=0;i<len;i++){
                freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            if(!groups.containsKey(freqMap)){
                groups.put(freqMap, new ArrayList<>());
            }
            groups.get(freqMap).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}