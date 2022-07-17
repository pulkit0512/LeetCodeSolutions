class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int max = -1;
        for(int num:nums){
            int x = num;
            int sum = 0;
            while(x>0){
                sum = sum + x%10;
                x = x/10;
            }
            if(!map.containsKey(sum)){
                map.put(sum, new int[]{-1,-1});
            }
            int[] val = map.get(sum);
            if(num>val[0]){
                val[1] = val[0];
                val[0] = num;
            }else if(num>val[1]){
                val[1] = num;
            }
            if(val[0]!=-1 && val[1]!=-1){
                max = Math.max(max, val[0] + val[1]);
            }
        }
        return max;
    }
}