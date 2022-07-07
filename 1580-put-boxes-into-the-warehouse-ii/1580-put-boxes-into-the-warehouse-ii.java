class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int bLen = boxes.length;
        int wLen = warehouse.length;
        int bIdx = bLen-1;
        int left = 0, right=wLen-1;
        int ans = 0;
        while(left<=right){
            while(bIdx>=0 && boxes[bIdx]>warehouse[left] && boxes[bIdx]>warehouse[right]){
                bIdx--;
            }
            if(bIdx==-1){
                break;
            }
            ans++;
            bIdx--;
            if(warehouse[left]>=warehouse[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}