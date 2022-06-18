class Solution {
    int m, n, target;
    int houses[];
    int cost[][];
    int INT_MAX = 10000000;
    Integer dp[][][];
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        this.target = target;
        this.houses = houses;
        this.cost = cost;
        this.dp = new Integer[100][21][100];
        
        int ans = minCostMemo(0, 0, 0);
        return ans==INT_MAX?-1:ans;
    }
    
    private int minCostMemo(int idx, int prev, int num) {
        if(idx==m) {
            if(num==target){
                return 0;
            }else{
                return INT_MAX;
            }
        }
        if(idx>m){
            return INT_MAX;
        }
        if(dp[idx][prev][num]!=null){
            return dp[idx][prev][num];
        }
            
        if(houses[idx]!=0){
            if(houses[idx]==prev){
                return minCostMemo(idx+1, prev, num);
            }else{
                return minCostMemo(idx+1, houses[idx], num + 1);
            }
        }else{
            int ans = INT_MAX;
            for(int i=1;i<=n;i++){
                if(prev!=i){
                    ans = Math.min(ans, cost[idx][i-1] + minCostMemo(idx+1, i, num+1));
                }else{
                    ans = Math.min(ans, cost[idx][i-1] + minCostMemo(idx+1, i, num));
                }
            }
            return dp[idx][prev][num] = ans;
        }
    }
}