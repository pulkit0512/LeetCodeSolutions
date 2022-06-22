// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCut(m,n));
                }
        }
}    // } Driver Code Ends


class Solution
{
	public int minCut(int m, int n)
	{
        // Your code goes here
        int memo[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(n, m, memo);
	}
	
	private int dp(int h, int w, int[][] memo){
        if(h==0 || w==0){
            return 0;
        }
        if(memo[h][w]!=-1){
            return memo[h][w];
        }
        int val = Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(h, w);x++){
            int hCut = dp(x, w-x, memo) + dp(h-x, w, memo);
            int vCut = dp(h-x, x, memo) + dp(h, w-x, memo);
            val = Math.min(val, Math.min(hCut, vCut)+1);
        }
        return memo[h][w] = val;
    }
}