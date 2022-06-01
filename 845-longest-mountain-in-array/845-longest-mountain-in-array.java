class Solution {
    public int longestMountain(int[] arr) {
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