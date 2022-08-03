class Solution {
    public int numberOfPatterns(int m, int n) {
        // Created a middle array to middle value between index i & j in the grid
        // middle[1][3] = middle[3][1] = 2 this indicates 2 is in middle of cell 1 & 3.
        int[][] middleNum = new int[10][10];
        middleNum[1][3] = middleNum[3][1] = 2;
        middleNum[1][7] = middleNum[7][1] = 4;
        middleNum[1][9] = middleNum[9][1] = 5;
        middleNum[2][8] = middleNum[8][2] = 5;
        middleNum[3][9] = middleNum[9][3] = 6;
        middleNum[3][7] = middleNum[7][3] = 5;
        middleNum[4][6] = middleNum[6][4] = 5;
        middleNum[7][9] = middleNum[9][7] = 8;
        
        // Created a visited array for backtracking
        boolean vis[] = new boolean[10];
        
        int res = 0;
        
        res += helper(middleNum, vis, 1, 1, 0, m, n)*4; // calculated answer for cell 1 and it would be same for 
        // 3,7,9 so multiply by 4
        res += helper(middleNum, vis, 2, 1, 0, m, n)*4; // calculated answer for cell 2 and it would be same for
        // 4,6,8 so multiply by 4
        res += helper(middleNum, vis, 5, 1, 0, m, n);
        
        return res;
    }
    
    private int helper(int[][] middle, boolean vis[], int num, int len, int accepted, int m, int n){
        // is length atleast m accept it.
        if(len>=m){
            accepted++;
        }
        len++;
        
        //if len is more than n then return accepted patterns.
        if(len>n){
            return accepted;
        }
        vis[num] = true;
        for(int i=1;i<=9;i++){
            // recursively call if i not visited yet and middle of num and i is 0 is already visited
            if(!vis[i] && (middle[num][i]==0 || vis[middle[num][i]])){
                accepted = helper(middle, vis, i, len, accepted, m, n);
            }
        }
        
        //backtrack
        vis[num] = false;
        
        return accepted;
    }
}