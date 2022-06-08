class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //return minRotationsUsingFreq(tops, bottoms);
        return minRotationsGreedy(tops, bottoms);
    }
    private int minRotationsGreedy(int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotations = getRotations(tops[0], tops, bottoms, n);
        if(rotations!=-1 || tops[0]==bottoms[0]){
            return rotations;
        }
        return getRotations(bottoms[0], tops, bottoms, n);
    }
    
    private int getRotations(int x, int[] tops, int[] bottoms, int n) {
        int rotA = 0, rotB = 0;
        for(int i=0;i<n;i++){
            if(tops[i]!=x && bottoms[i]!=x){
                return -1;
            }else if(tops[i]!=x){
                rotA++;
            }else if(bottoms[i]!=x){
                rotB++;
            }
        }
        return Math.min(rotA, rotB);
    }
    
    private int minRotationsUsingFreq(int[] tops, int[] bottoms) {
        int[] topFreq = new int[7];
        int[] bottomFreq = new int[7];
        int[] commonMap = new int[7];
        int n = tops.length;
        for(int i=0;i<n;i++){
            topFreq[tops[i]]++;
            bottomFreq[bottoms[i]]++;
            if(tops[i]==bottoms[i]){
                commonMap[tops[i]]++;
            }
        }
        int topSwaps = n+1;
        for(int i=1;i<=6;i++){
            if(topFreq[i]==n || bottomFreq[i]==n){
                return 0;
            }
            if(topFreq[i] + bottomFreq[i] - commonMap[i]==tops.length){
                topSwaps = Math.min(topSwaps, Math.min(topFreq[i], bottomFreq[i]) - commonMap[i]);
            }
        }
        if(topSwaps == n+1){
            return -1;
        }
        return topSwaps;
    }
}

/*
3 5 1 2 3
3 6 3 3 4
*/