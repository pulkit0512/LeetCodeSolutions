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
        worker[] w = new worker[n];
        for(int i=0;i<n;i++){
            w[i] = new worker(wage[i], quality[i]);
        }
        Arrays.sort(w, (a,b) -> (Double.compare(a.ratio, b.ratio)));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double ans = Double.MAX_VALUE;
        for(worker x:w){
            qualitySum += x.quality;
            pq.add(x.quality);
            if(pq.size()>k){
                qualitySum -= pq.poll();
            }
            if(pq.size()==k){
                ans = Math.min(ans, qualitySum * x.ratio);
            }
        }
        return ans;
    }
    
    private double minCostToHireWorkersN2LogN(int[] quality, int[] wage, int k) {
        // O(N*NLog(N)) TLE
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