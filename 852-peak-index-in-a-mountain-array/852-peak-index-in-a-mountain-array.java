class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return findPivot(arr);
    }
    
    public int findPivot(int arr[]){
        int st = 1, ed = arr.length-2;
        int idx = -1;
        while(st<=ed){
            int mid = (st+ed)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                idx = mid;
                break;
            }
            if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]){
                ed = mid-1;
            }else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                st = mid+1;
            }
        }
        return idx;
    }
}