class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2==1){
            return new int[0];
        }
        
        int max = 0;
        for(int num:changed){
            max = Math.max(max, num);
        }
        max = 2*max;
        
        int[] cnt = new int[max+1];
        for(int num:changed){
            cnt[num]++;
        }
        
        int[] ans = new int[n/2];
        int idx = 0;
        
        for(int i=0;i<=max;i++){
            if(cnt[i]!=0){
                int val = cnt[i];
                
                if(i==0){
                    for(int j=0;j<val;j+=2){
                        ans[idx++] = i;
                    }
                    continue;
                }
                
                int doubleVal = cnt[2*i];
                int minValue = Math.min(val, doubleVal);
                
                if(val-minValue!=0){
                    return new int[0];
                }else{
                    for(int j=0;j<val;j++){
                        ans[idx++] = i;
                    }
                }
                
                cnt[i] = val - minValue;
                cnt[2*i] = doubleVal - minValue;
            }
        }
        
        return ans;
    }
}