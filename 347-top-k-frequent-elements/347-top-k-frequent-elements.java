class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (freqMap.get(a) - freqMap.get(b)));
        for(int key:freqMap.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[] = new int[k];
        int idx = 0;
        while(!pq.isEmpty()) {
            ans[idx++] = pq.poll();
        }
        return ans;
    }
}