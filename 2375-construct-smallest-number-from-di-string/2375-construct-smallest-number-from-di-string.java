class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int[] arr = new int[n+1];
        int prev = 0;
        for(int i=0;i<n;i++){
            if(pattern.charAt(i)=='I'){
                arr[i] = ++prev;
            }else{
                int j=i;
                while(j<n && pattern.charAt(j)=='D'){
                    j++;
                }
                int cur=j;
                while(j>=i){
                    arr[j--] = ++prev;
                }
                i = cur;
            }
        }
        if(arr[n]==0){
            arr[n] = ++prev;
        }
        StringBuilder sb = new StringBuilder();
        for(int x:arr){
            sb.append(x);
        }
        return sb.toString();
    }
}