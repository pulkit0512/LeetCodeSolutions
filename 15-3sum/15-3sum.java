class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1, k = n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    j++;
                }
                while(j!=i+1 && j<k && nums[j]==nums[j-1]){
                    j++;
                }
                while(k!=n-1 && k>j && nums[k]==nums[k+1]){
                    k--;
                }
            }
        }
        return ans;
    }
}