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
        //return jobSchedulingUsingPriorityQueue(startTime, endTime, profit);
        return jobSchedulingUsingDP(startTime, endTime, profit);
    }
    
    private int jobSchedulingUsingDP(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n+1];
        JobData[] arr = new JobData[n];
        for(int i=0;i<n;i++){
            arr[i] = new JobData(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(arr, (a, b) -> (a.sTime - b.sTime));
        
        for(int i=n-1;i>=0;i--){
            int nextIndex = getNextJobIndex(arr, arr[i].eTime);
            int curProfit = arr[i].profit;
            if(nextIndex!=n){
                curProfit += dp[nextIndex];
            }
            
            if(i==n-1){
                dp[i] = curProfit;
            }else{
                dp[i] = Math.max(curProfit, dp[i+1]);
            }
        }
        
        return dp[0];
    }
    
    private int getNextJobIndex(JobData[] arr, int endTime) {
        int st = 0, ed = arr.length-1;
        int nextIndex = arr.length;
        while(st<=ed) {
            int mid = (st+ed)/2;
            if(arr[mid].sTime>=endTime){
                nextIndex = mid;
                ed = mid-1;
            }else{
                st = mid+1;
            }
        }
        return nextIndex;
    }
    
    private int jobSchedulingUsingPriorityQueue(int[] startTime, int[] endTime, int[] profit) {
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