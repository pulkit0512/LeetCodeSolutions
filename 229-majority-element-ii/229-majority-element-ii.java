class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int cntA = 0, cntB = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==a){
                cntA++;
            }else if(nums[i]==b){
                cntB++;
            }else if(cntA==0){
                cntA = 1;
                a = nums[i];
            }else if(cntB==0){
                cntB = 1;
                b = nums[i];
            }else{
                cntA--;
                cntB--;
            }
        }
        cntA = 0;
        cntB = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==a){
                cntA++;
            }else if(nums[i]==b){
                cntB++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(cntA > n/3){
            ans.add(a);
        }
        if(cntB > n/3){
            ans.add(b);
        }
        return ans;
    }
}