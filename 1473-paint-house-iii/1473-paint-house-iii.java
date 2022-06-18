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
        //return memoizationDP();
        return tabulationDP();
    }
    
    private int tabulationDP(){
        int prevDp[][] = new int[target+1][n];
        for(int i=0;i<=target;i++){
            Arrays.fill(prevDp[i], INT_MAX);
        }
        //Populate base case for house at index 0 with number of neighbours becoming 1.
        for(int color=1;color<=n;color++){
            if(houses[0]==color){
                prevDp[1][color-1] = 0;
            }else if(houses[0]==0){
                prevDp[1][color-1] = cost[0][color-1];
            }
        }
        for(int house=1;house<m;house++){
            int currDp[][] = new int[target+1][n];
            for(int i=0;i<=target;i++){
                Arrays.fill(currDp[i], INT_MAX);
            }
            for(int neighbour = 1;neighbour<=Math.min(target, house+1);neighbour++){
                for(int color = 1;color<=n;color++){
                    if(houses[house]!=0 && houses[house]!=color){
                        continue;
                    }
                    int currCost = INT_MAX;
                    for(int prev=1;prev<=n;prev++){
                        int newNeighbour = (prev==color)?neighbour:neighbour-1;
                        currCost = Math.min(currCost, prevDp[newNeighbour][prev-1]);
                    }
                    int costToPaint = houses[house]!=0?0:cost[house][color-1];
                    currDp[neighbour][color-1] = currCost + costToPaint;
                }
            }
            prevDp = currDp;
        }
        int minCost = INT_MAX;
        for(int i=0;i<n;i++){
            minCost = Math.min(minCost, prevDp[target][i]);
        }
        return minCost == INT_MAX? -1: minCost;
    }
    
    private int memoizationDP(){
        this.dp = new Integer[m][target+1][n+1];
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
        if(idx>m || num>target){
            return INT_MAX;
        }
        if(dp[idx][num][prev]!=null){
            return dp[idx][num][prev];
        }
            
        if(houses[idx]!=0){
            int newNum = (prev==houses[idx])?num:num+1;
            return minCostMemo(idx+1, houses[idx], newNum);
        }else{
            int ans = INT_MAX;
            for(int i=1;i<=n;i++){
                int newNum = (prev!=i)?num+1:num;
                ans = Math.min(ans, cost[idx][i-1] + minCostMemo(idx+1, i, newNum));
            }
            return dp[idx][num][prev] = ans;
        }
    }
}