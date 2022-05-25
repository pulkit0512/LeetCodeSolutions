class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //return maxEnvelopesLisN2(envelopes);
        return maxEnvelopesLisNLogN(envelopes);
    }
    
    private int maxEnvelopesLisN2(int[][] envelopes) {
        // N^2 LIS approach gives tle
        Arrays.sort(envelopes, (a,b) -> a[0]-b[0]);
        int n = envelopes.length;
        int ans = 1;
        int lis[] = new int[n];
        lis[0] = 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(envelopes[i][1]>envelopes[j][1] && envelopes[i][0]!=envelopes[j][0]){
                    max = Math.max(max, lis[j]);
                }
                if(max==ans){
                    break;
                }
            }
            lis[i] = max+1;
            ans = Math.max(ans, lis[i]);
        }
        return ans;
    }
    
    private int maxEnvelopesLisNLogN(int[][] envelopes) {
        // NLogN Lis approach
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }
        });
        int n = envelopes.length;
        int heights[] = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = envelopes[i][1];
        }
        return lengthLis(heights);
    }
    
    private int lengthLis(int[] height) {
        int lis[] = new int[height.length];
        lis[0] = height[0];
        int length = 1;
        for(int i=1;i<height.length;i++){
            if(height[i]>lis[length-1]){
                lis[length] = height[i];
                length++;
            }else{
                int idx = Arrays.binarySearch(lis, 0, length-1, height[i]);
                if(idx<0){
                    idx = -(idx+1);
                }
                lis[idx] = height[i];
            }
        }
        return length;
    }
}