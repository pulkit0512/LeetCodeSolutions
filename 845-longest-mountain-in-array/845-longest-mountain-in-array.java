class Solution {
    public int longestMountain(int[] arr) {
        //return longestMountainUsingLeftRightIncreasingArrays(arr);
        
        //Follow Up using O(1) Space and in one pass
        return longestMountainUsingConstantSpace(arr);
    }
    
    private int longestMountainUsingConstantSpace(int[] arr) {
        int n = arr.length;
        int base = 0, ans = 0;
        while(base<n) {
            int end = base;
            if(end+1<n && arr[end]<arr[end+1]){
                while(end+1<n && arr[end]<arr[end+1]){
                    end++;
                }
                if(end+1<n && arr[end]>arr[end+1]){
                    while(end+1<n && arr[end]>arr[end+1]){
                        end++;
                    }
                    ans = Math.max(ans, end-base+1);
                }
            }
            base = Math.max(end, base+1);
        }
        return ans;
    }
    
    private int longestMountainUsingLeftRightIncreasingArrays(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 0;
            }
            
            if(arr[n-1-i]>arr[n-i]){
                right[n-1-i] = right[n-i] + 1;
            }else{
                right[n-1-i] = 0;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(left[i]>0 && right[i]>0) {
                ans = Math.max(ans, left[i]+right[i]+1);
            }
        }
        if(ans>=3){
            return ans;
        }
        return 0;
    }
}