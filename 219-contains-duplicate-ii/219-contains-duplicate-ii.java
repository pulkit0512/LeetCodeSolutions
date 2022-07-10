class Solution {
    class Pair{
        int val, idx;
        public Pair(int a, int b){
            val = a;
            idx = b;
        }
    }
    class Sort implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            if(a.val==b.val){
                return a.idx-b.idx;
            }else{
                return a.val-b.val;
            }
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Pair[] pArr = new Pair[n];
        for(int i=0;i<n;i++){
            pArr[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pArr, new Sort());
        Pair prev = pArr[0];
        for(int i=1;i<n;i++){
            if(pArr[i].val==prev.val){
                if(pArr[i].idx - prev.idx <= k){
                    return true;
                }
            }
            prev = pArr[i];
        }
        return false;
    }
}