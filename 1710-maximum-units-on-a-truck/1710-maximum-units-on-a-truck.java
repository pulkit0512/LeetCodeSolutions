class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> (b[1]-a[1]));
        int totalUnits = 0;
        int idx = 0;
        while(truckSize>0 && idx<boxTypes.length){
            int boxes = Math.min(truckSize, boxTypes[idx][0]);
            truckSize -= boxes;
            totalUnits += boxes*boxTypes[idx][1];
            idx++;
        }
        return totalUnits;
    }
}