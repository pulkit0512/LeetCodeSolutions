class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int n = security.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        for(int i=1;i<n;i++){
            if(security[i]<=security[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 0;
            }
            
            if(security[n-1-i]<=security[n-i]){
                right[n-1-i] = right[n-i] + 1;
            }else{
                right[n-1-i] = 0;
            }
        }
        for(int i=0;i<n;i++){
            //System.out.println(i+": "+left[i]+" "+right[i]);
            if(left[i]>=time && right[i]>=time){
                ans.add(i);
            }
        }
        return ans;
    }
}