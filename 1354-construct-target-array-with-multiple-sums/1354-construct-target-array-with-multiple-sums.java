class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(int tar:target){
            pq.add((long)tar);
            sum += tar;
        }
        while(pq.peek()!=1){
            long x = pq.poll();
            long rest = sum-x;
            if(rest==1){
                return true;
            }
            if(rest<=0 || x<=rest){
                return false;
            }
            long newX = x%rest;
            sum = rest + newX;
            pq.add(newX);
        }
        if(sum==target.length){
            return true;
        }else{
            return false;
        }
    }
}