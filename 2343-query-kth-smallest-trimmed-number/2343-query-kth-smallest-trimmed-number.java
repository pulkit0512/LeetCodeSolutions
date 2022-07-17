class Solution {
    class Sort implements Comparator<Pair<String, Integer>> {
        public int compare(Pair<String, Integer> a, Pair<String, Integer> b) {
            int val = a.getKey().compareTo(b.getKey());
            if(val==0){
                return a.getValue()-b.getValue();
            }
            return val;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer, PriorityQueue<Pair<String, Integer>>> map = new HashMap<>();
        int len = nums[0].length();
        for(int i=len;i>=1;i--){
            map.put(i, new PriorityQueue<>(new Sort()));
            for(int j=0;j<nums.length;j++){
                String subStr = nums[j].substring(len-i);
                map.get(i).add(new Pair<>(subStr, j));
            }
        }
        
        int qLen = queries.length;
        int ans[] = new int[qLen];
        
        for(int i=0;i<qLen;i++){
            PriorityQueue<Pair<String, Integer>> pq = map.get(queries[i][1]);
            Stack<Pair<String, Integer>> st = new Stack<>();
            for(int j=1;j<queries[i][0];j++){
                st.push(pq.poll());
            }
            ans[i] = pq.peek().getValue();
            while(!st.isEmpty()){
                pq.add(st.pop());
            }
        }
        return ans;
    }
}