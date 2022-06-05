class Solution {
    public boolean find132pattern(int[] nums) {
        //return find132patternUsingStack(nums);
        return find132patternUsingArrayAsStack(nums);
    }
    
    private boolean find132patternUsingStack(int[] nums) {
        int n = nums.length;
        if(n<3){
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for(int j=n-1;j>=0;j--){
            if(nums[j]>min[j]){
                while(!st.isEmpty() && st.peek()<=min[j]){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()<nums[j]){
                    return true;
                }
                st.push(nums[j]);
            }
        }
        return false;
    }
    
    private boolean find132patternUsingArrayAsStack(int[] nums) {
        int n = nums.length;
        if(n<3){
            return false;
        }
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for(int j=n-1, k=n;j>=0;j--){
            if(nums[j]>min[j]){
                while(k<n && nums[k]<=min[j]){
                    k++;
                }
                if(k<n && nums[k]<nums[j]){
                    return true;
                }
                nums[--k] = nums[j];
            }
        }
        return false;
    }
}