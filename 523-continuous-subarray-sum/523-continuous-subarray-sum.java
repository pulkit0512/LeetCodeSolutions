class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        map.put(sum, -1);
        for(int i=0;i<nums.length;i++){
            sum = (sum + nums[i]%k)%k;
            if(map.containsKey(sum)){
                len = Math.max(len, i-map.get(sum));
                if(len>=2){
                    break;
                }
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return (len>=2);
    }
}