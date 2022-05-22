class Solution {

    int[] prefix;
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for(int i=1;i<w.length;i++){
            prefix[i] = prefix[i-1] + w[i];
        }
    }
    
    public int pickIndex() {
        double target = prefix[prefix.length-1] * Math.random();
        return binarySearch(target);
    }
    
    private int binarySearch(double target){
        int st = 0, ed = prefix.length-1;
        while(st<ed){
            int mid = (st+ed)/2;
            if(prefix[mid]<target){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        return st;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */