class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        long[] cnt = new long[32];
        for(int x:list){
            cnt[Integer.bitCount(x)]++;
        }
        long ans = 0;
        for(int i=0;i<32;i++){
            for(int j=0;j<32;j++){
                if(i+j>=k){
                    ans += cnt[i]*cnt[j];
                }
            }
        }
        return ans;
    }
}