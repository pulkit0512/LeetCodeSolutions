class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(target.length, Collections.reverseOrder());
        long sum = 0;
        for(int tar:target){
            pq.add((long)tar);
            sum += tar;
        }
        while(pq.peek()!=1){
            long max = pq.poll();
            long rest = sum-max;
            if(rest<=0 || max<=rest){
                return false;
            }
            if(rest==1){
                return true;
            }
            long newX = max%rest;
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