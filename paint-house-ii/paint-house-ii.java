class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            if(costs[0][j]<min){
                min2 = min;
                min = costs[0][j];
            }else if(costs[0][j]<min2){
                min2 = costs[0][j];
            }
        }
        for(int i=1;i<n;i++){
            int newMin = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(min==costs[i-1][j]){
                    costs[i][j] += min2;
                }else{
                    costs[i][j] += min;
                }
                if(costs[i][j]<newMin){
                    newMin2 = newMin;
                    newMin = costs[i][j];
                }else if(costs[i][j]<newMin2){
                    newMin2 = costs[i][j];
                }
            }
            min = newMin;
            min2 = newMin2;
        }
        int ans = costs[n-1][0];
        for(int j=1;j<k;j++){
            ans = Math.min(ans, costs[n-1][j]);
        }
        return ans;
    }
}