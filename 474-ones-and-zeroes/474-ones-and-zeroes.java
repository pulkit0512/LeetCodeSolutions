class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length==0){
            return 0;
        }
        int[][] binary = new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            int len = strs[i].length();
            for(int j=0;j<len;j++){
                if(strs[i].charAt(j)=='0'){
                    binary[i][0]++;
                }else{
                    binary[i][1]++;
                }
            }
        }
        //return findMaxFormUsingMemoization(binary, m, n);
        return findMaxFormUsingDP(binary, m, n);
    }
    private int findMaxFormUsingDP(int[][] binary, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<binary.length;i++){
            for(int j=m;j>=binary[i][0];j--){
                for(int k=n;k>=binary[i][1];k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j-binary[i][0]][k-binary[i][1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    
    private int findMaxFormUsingMemoization(int[][] binary, int m , int n){
        int[][][] mem = new int[binary.length][m+1][n+1];
        return memoDp(binary, 0, m , n, mem);
    }
    
    private int memoDp(int[][] binary, int i, int m, int n, int[][][] mem){
        if(i==binary.length){
            return 0;
        }
        if(mem[i][m][n]!=0){
            return mem[i][m][n];
        }
        int taken = 0;
        if(m-binary[i][0]>=0 && n-binary[i][1]>=0){
            taken = memoDp(binary, i+1, m-binary[i][0], n-binary[i][1], mem) + 1;
        }
        int notTaken = memoDp(binary, i+1, m, n, mem);
        mem[i][m][n] = Math.max(taken, notTaken);
        return mem[i][m][n];
    }
}