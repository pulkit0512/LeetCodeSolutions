class Solution {
    public void duplicateZeros(int[] arr) {
        int zero = 0;
        int n = arr.length;
        int idx = n-1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                zero++;
            }
            if(i+zero>=n-1){
                idx = i;
                break;
            }
        }
        //System.out.println(idx+" "+zero);
        for(int i=idx;i>=0;i--){
            if(arr[i]!=0){
                arr[i+zero] = arr[i];
            }else{
                if(i+zero<n){
                    arr[i+zero] = 0;
                }
                zero--;
                arr[i+zero] = arr[i];
            }
        }
    }
}