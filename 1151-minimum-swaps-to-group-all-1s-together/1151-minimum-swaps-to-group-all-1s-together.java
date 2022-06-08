class Solution {
    public int minSwaps(int[] data) {
        int inPlace = 0;
        int swaps = data.length;
        int cnt1 = 0;
        for(int i:data){
            if(i==1){
                cnt1++;
            }
        }
        for(int i=0;i<data.length;i++){
            if(i<cnt1){
                if(data[i]==1){
                    inPlace++;
                }
            }else{
                swaps = Math.min(swaps, cnt1-inPlace);
                if(data[i-cnt1]==1){
                    inPlace--;
                }
                if(data[i]==1){
                    inPlace++;
                }
            }
        }
        swaps = Math.min(swaps, cnt1-inPlace);
        return swaps;
    }
}