class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int bLen = boxes.length;
        int wLen = warehouse.length;
        for(int i=1;i<wLen;i++){
            warehouse[i] = Math.min(warehouse[i], warehouse[i-1]);
        }
        int ans = 0;
        int bIdx = 0, wIdx = wLen-1;
        while(bIdx<bLen && wIdx>=0){
            if(warehouse[wIdx]>=boxes[bIdx]){
                ans++;
                bIdx++;
            }
            wIdx--;
        }
        return ans;
    }
}