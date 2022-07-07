class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        //return maxBoxesInWarehouse1(boxes, warehouse);
        return maxBoxesInWarehouse2(boxes, warehouse);
    }
    
    private int maxBoxesInWarehouse1(int[] boxes, int[] warehouse) {
        // Add Smallest Boxes to the Rightmost Warehouse Rooms
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
    
    private int maxBoxesInWarehouse2(int[] boxes, int[] warehouse) {
        // Add Largest Possible Boxes from Left to Right
        Arrays.sort(boxes);
        int bLen = boxes.length;
        int wLen = warehouse.length;
        int bIdx = bLen-1;
        int ans = 0;
        for(int i=0;i<wLen;i++){
            while(bIdx>=0 && boxes[bIdx]>warehouse[i]){
                bIdx--;
            }
            if(bIdx==-1){
                break;
            }
            ans++;
            bIdx--;
        }
        return ans;
    }
}