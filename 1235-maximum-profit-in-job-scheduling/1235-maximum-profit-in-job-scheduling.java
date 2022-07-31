class Solution {
    class JobData {
        int sTime, eTime, profit;
        public JobData(int a, int b, int c) {
            sTime = a;
            eTime = b;
            profit = c;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        JobData[] arr = new JobData[n];
        for(int i=0;i<n;i++){
            arr[i] = new JobData(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(arr, (a, b) -> (a.sTime - b.sTime));
        int maxProfit = 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> (a.get(0) - b.get(0)));
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && arr[i].sTime>=pq.peek().get(0)){
                maxProfit = Math.max(maxProfit, pq.poll().get(1));
            }
            List<Integer> combined = new ArrayList<>();
            combined.add(arr[i].eTime);
            combined.add(arr[i].profit + maxProfit);
            
            pq.add(combined);
        }
        
        while(!pq.isEmpty()){
            maxProfit = Math.max(maxProfit, pq.poll().get(1));
        }
        
        return maxProfit;
    }
    
}