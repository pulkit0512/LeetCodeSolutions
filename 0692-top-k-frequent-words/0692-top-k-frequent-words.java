class Solution {
    class Sort implements Comparator<Map.Entry<String, Integer>> {
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
            if((int)a.getValue()==(int)b.getValue()){
                return b.getKey().compareTo(a.getKey());
            }
            return (int)a.getValue() - (int)b.getValue();
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word:words){
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Sort());
        for(Map.Entry<String, Integer> entry:freqMap.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}