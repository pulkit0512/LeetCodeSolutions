class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int len[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++){
            if(i!=n && (st.isEmpty() || nums[st.peek()]<=nums[i])){
                st.push(i);
            }else{
                while(!st.isEmpty() && (i==n || nums[st.peek()]>nums[i])){
                    int pop = st.pop();
                    int low = st.isEmpty()?-1:st.peek();
                    len[pop] = i-low-1;
                }
                st.push(i);
            }
        }
        /*System.out.println(st);
        while(!st.isEmpty()){
            int pop = st.pop();
            int low = st.isEmpty()?-1:st.peek();
            len[pop] = n-low-1;
        }
        for(int i=0;i<n;i++){
            System.out.print(len[i]+" ");
        }
        System.out.println();*/
        for(int i=0;i<n;i++){
            if(nums[i]>threshold/len[i]){
                return len[i];
            }
        }
        return -1;
    }
}