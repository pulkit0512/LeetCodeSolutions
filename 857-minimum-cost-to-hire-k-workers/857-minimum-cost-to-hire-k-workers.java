class Solution {
    class worker{
        int wage, quality;
        double ratio;
        worker(int a, int b){
            wage = a;
            quality = b;
            ratio = (double)a/b;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // O(N*NLog(N))
        //return minCostToHireWorkersN2LogN(quality, wage, k);
        
        
        // O(NLog(N))
        return minCostToHireWorkersNLogN(quality, wage, k);
    }
    private double minCostToHireWorkersNLogN(int[] quality, int[] wage, int k) {
        int n = wage.length;
        worker[] workers = new worker[n];
        for(int i=0;i<n;i++){
            workers[i] = new worker(wage[i], quality[i]);
        }
        Arrays.sort(workers, (a,b) -> (Double.compare(a.ratio, b.ratio)));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sumq = 0;
        double ans = Double.MAX_VALUE;
        for(worker w:workers){
            //System.out.println(w.wage+" "+w.quality+" "+w.ratio);
            sumq += w.quality;
            pq.add(w.quality);
            if(pq.size()>k){
                sumq -= pq.poll();
            }
            if(pq.size()==k){
                ans = Math.min(ans, sumq * w.ratio);
            }
        }
        return ans;
    }
    
    private double minCostToHireWorkersN2LogN(int[] quality, int[] wage, int k) {
        // O(N*NLog(N))
        double ans = Double.MAX_VALUE;
        for(int i=0;i<wage.length;i++){
            double temp = 0.0;
            double factor = (double)wage[i]/quality[i];
            List<Double> cost = new ArrayList<>();
            for(int j=0;j<wage.length;j++){
                double val = factor*quality[j];
                if(val>=wage[j]){
                    cost.add(val);
                }
            }
            //System.out.println(cost);
            if(cost.size()<k){
                continue;
            }
            if(cost.size()>k){
                Collections.sort(cost);
            }
            for(int j=0;j<k;j++){
                temp += cost.get(j);
            }
            //System.out.println(temp);
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}