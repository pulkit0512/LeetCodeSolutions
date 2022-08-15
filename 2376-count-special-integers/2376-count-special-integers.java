class Solution {
    public int countSpecialNumbers(int n) {
        // for numbers having less digits then digits in n.
        // Suppose we want to make number of length x. So the number of ways will be 9 * (9 * 8 * ... * (9-x+1)).
        // First 9 will be because we can have 9 digits as the first number i.e. except 0 
        // and remaining are the ways for putting the remaining numbers in different orders.
        String s = String.valueOf(n);
        int len = s.length();
        int ans = 0;
        for(int i=1;i<len;i++){
            int k = 9, p = 1;
            for(int j=0;j<i-1;j++){
                p = p*k;
                k--;
            }
            ans = ans + 9*p; // number of special integers which are having digits less then digits in n.
        }
        
        // For each position s[i] we calculate the digits less than s[i] which we can keep at this position and is not taken previously
        // and multiplying this count with the ways to fill remaining digits which is similar to what we did above.
        boolean[] done = new boolean[10];
        for(int i=0;i<len;i++){
            int smaller = 0;
            int cur = s.charAt(i)-'0';
            for(int j=0;j<cur;j++){
                if(!done[j]){
                    smaller++;
                }
            }
            if(i==0 && cur>0){
                smaller--;
            }
            int nextSpecial = 1, possible = 9-i;
            for(int j=i+1;j<len;j++){
                nextSpecial *= possible;
                possible--;
            }
            ans = ans + smaller*nextSpecial;
            if(!done[cur]){
                done[cur] = true;
            }else{
                // Cur number is repeated then if we move forward we won't be getting any special numbers
                // Since this digit will be repeated for all of them so return answer from here.
                return ans;
            }
        }
        // ans + 1 for n itself.
        return ans+1;
    }
}