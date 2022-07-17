class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int hcf = getHcf(numsDivide);
        //System.out.println(hcf);
        for(int i=0;i<nums.length;i++){
            if(hcf%nums[i]==0){
                return i;
            }
            if(nums[i]>hcf){
                break;
            }
        }
        return -1;
    }
    
    private int getHcf(int[] numsDivide) {
        int res = numsDivide[0];
        for(int i=1;i<numsDivide.length;i++){
            res = gcd(res, numsDivide[i]);
            if(res==1){
                return 1;
            }
        }
        return res;
    }
    
    private int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}