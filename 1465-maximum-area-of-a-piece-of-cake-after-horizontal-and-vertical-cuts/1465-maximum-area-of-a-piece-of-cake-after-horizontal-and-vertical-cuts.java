class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = horizontalCuts[0];
        int maxW = verticalCuts[0];
        int hLen = horizontalCuts.length;
        int wLen = verticalCuts.length;
        for(int i=1;i<hLen;i++){
            maxH = Math.max(maxH, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        maxH = Math.max(maxH, h-horizontalCuts[hLen-1]);
        for(int i=1;i<wLen;i++){
            maxW = Math.max(maxW, verticalCuts[i]-verticalCuts[i-1]);
        }
        maxW = Math.max(maxW, w-verticalCuts[wLen-1]);
        return (int)((((long)maxH)*maxW)%1000000007);
    }
}