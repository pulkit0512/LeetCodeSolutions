// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            int len = -1, cost = 0;
            for(int j=i;j<n;j++){
                len += nums[j] + 1;
                if(len>k){
                    break;
                }
                if(j==n-1){
                    cost = 0;
                }else{
                    cost = (k-len)*(k-len) + dp[j+1];
                }
                dp[i] = Math.min(dp[i], cost);
            }
        }
        return dp[0];
    }
}