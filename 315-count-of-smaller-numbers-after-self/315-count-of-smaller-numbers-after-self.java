class Solution {
    class pair{
        int val, idx;
        pair(int a, int b){
            val = a;
            idx = b;
        }
    }
    pair[] temp;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        temp = new pair[n];
        count = new int[n];
        pair[] arr = new pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new pair(nums[i], i);
        }
        sort(arr, 0, n-1);
        List<Integer> ans = new ArrayList<>();
        for(int num:count){
            ans.add(num);
        }
        /*for(int i=0;i<n;i++){
            System.out.println(arr[i].val);
        }*/
        return ans;
    }
    private void sort(pair arr[], int st, int ed){
        if(st>=ed){
            return;
        }
        int mid = (st+ed)/2;
        sort(arr, st, mid);
        sort(arr, mid+1, ed);
        merge(arr, st, mid, ed);
    }
    private void merge(pair arr[], int left, int middle, int right){
        int i = left, j = middle+1, k = left;
        while(i<=middle && j<=right){
            if(arr[i].val>arr[j].val){
                count[arr[i].idx] += (right-j+1);
                temp[k] = arr[i++];
            }else{
                temp[k] = arr[j++];
            }
            k++;
        }
        while(i<=middle){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }
        for(i=left;i<=right;i++){
            arr[i] = temp[i];
        }
    }
}