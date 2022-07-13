class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1, k=n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    j++;
                }
                while(j!=i+1 && j<n && nums[j]==nums[j-1]){
                    j++;
                }
                while(k!=n-1 && k>=0 && nums[k]==nums[k+1]){
                    k--;
                }
            }
        }
        return result;
    }
}