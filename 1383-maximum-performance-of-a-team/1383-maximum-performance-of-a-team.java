class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Pair<Integer, Integer>> engineers = new ArrayList<>();
        for(int i=0;i<n;i++){
            engineers.add(new Pair(efficiency[i], speed[i]));
        }
        
        Collections.sort(engineers, (a,b) -> b.getKey() - a.getKey());
        
        PriorityQueue<Integer> speedPq = new PriorityQueue<>();
        
        long curSum = 0;
        int mod = 1000000007;
        long ans = 0;
        for(Pair engineer:engineers) {
            int eff = (int)engineer.getKey();
            int spd = (int)engineer.getValue();
            
            if(speedPq.size()>k-1){
                curSum -= speedPq.poll();
            }
            speedPq.add(spd);
            curSum += spd;
            ans = Math.max(ans, curSum*eff);
        }
        return (int)(ans%mod);
    }
}