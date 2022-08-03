class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = 0;
        boolean first1 = false;
        int ans = 0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                if(!first1){
                    first1 = true;
                    ans = Math.max(ans, i-left);
                }else {
                    ans = Math.max(ans, (i-left)/2);
                }
                left = i;
            }
        }
        ans = Math.max(ans, seats.length-1-left);
        return ans;
    }
}