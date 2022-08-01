class Solution {
    public int uniquePaths(int m, int n) {
        if(m<n){
            return uniquePaths(n, m);
        }
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}

/*
In the process to move from the upper left corner to the lower right corner, we need to move m + n - 2 times. Among them, there are m – 1 moves down and n – 1 moves to the right. Therefore, the total number of possible paths is equal to the number of combinations for selecting m – 1 downward moves from m + n – 2 total moves, and the number of combinations can be calculated as,

(m+n-2) C (m-1) = (m+n-2)!/((m-1)! * (n-1)!)

## time complexity: O(M)
## Space Complexity: O(1)
*/