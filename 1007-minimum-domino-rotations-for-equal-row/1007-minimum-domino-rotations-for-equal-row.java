class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topFreq = new int[7];
        int[] bottomFreq = new int[7];
        int[] topMap = new int[7];
        int[] bottomMap = new int[7];
        for(int i=0;i<tops.length;i++){
            topFreq[tops[i]]++;
            bottomFreq[bottoms[i]]++;
            if(tops[i]!=bottoms[i]){
                topMap[tops[i]]++;
            }
            if(tops[i]!=bottoms[i]){
                bottomMap[bottoms[i]]++;
            }
        }
        int topSwaps = tops.length+1;
        for(int i=1;i<=6;i++){
            if(topFreq[i]==tops.length){
                return 0;
            }
            if(topFreq[i]+bottomMap[i]==tops.length){
                topSwaps = Math.min(topSwaps, bottomMap[i]);
            }
            if(bottomFreq[i]+topMap[i]==tops.length){
                topSwaps = Math.min(topSwaps, topMap[i]);
            }
        }
        if(topSwaps == tops.length+1){
            return -1;
        }
        return topSwaps;
    }
}

/*
3 5 1 2 3
3 6 3 3 4
*/