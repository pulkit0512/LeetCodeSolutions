class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long scores[] = new long[n];
        long maxScore = 0;
        int maxNode = 0;
        for(int i=0;i<n;i++){
            scores[edges[i]] += i;
        }
        for(int i=0;i<n;i++){
            if(scores[i]>maxScore){
                maxScore = scores[i];
                maxNode = i;
            }
        }
        return maxNode;
    }
}