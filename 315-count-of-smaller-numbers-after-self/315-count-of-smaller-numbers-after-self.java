class Solution {
    int[] count;
    Pair<Integer, Integer>[] temp;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair<Integer, Integer>[] pair = new Pair[n];
        temp = new Pair[n];
        count = new int[n];
        for(int i=0;i<n;i++){
            pair[i] = new Pair<>(nums[i], i);
        }
        sort(pair, 0, n-1);
        List<Integer> result = new ArrayList<>();
        for(int cnt:count){
            result.add(cnt);
        }
        return result;
    }
    
    private void sort(Pair<Integer, Integer>[] pair, int st, int ed) {
        if(st>=ed){
            return;
        }
        int mid = (st+ed)/2;
        sort(pair, st, mid);
        sort(pair, mid+1, ed);
        merge(pair, st, mid, ed);
    }
    
    private void merge(Pair<Integer, Integer>[] pair, int left, int mid, int right) {
        int i = left, j=mid+1;
        int k = left;
        while(i<=mid && j<=right){
            if((int)pair[i].getKey()>(int)pair[j].getKey()){
                count[pair[i].getValue()] += (right-j+1);
                temp[k++] = pair[i++];
            }else{
                temp[k++] = pair[j++];
            }
        }
        while(i<=mid){
            temp[k++] = pair[i++];
        }
        while(j<=right){
            temp[k++] = pair[j++];
        }
        for(i=left;i<=right;i++){
            pair[i] =temp[i];
        }
    }
}