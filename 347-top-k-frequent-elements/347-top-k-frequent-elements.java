class Solution {
    class sort implements Comparator<Map.Entry<Integer, Integer>> {
        public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
            return (int)a.getValue() - (int)b.getValue();
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> ((int)a.getValue() - (int)b.getValue()));
        for(Map.Entry<Integer, Integer> entry:freqMap.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[] = new int[k];
        int idx = 0;
        while(!pq.isEmpty()) {
            ans[idx++] = pq.poll().getKey();
        }
        return ans;
    }
}