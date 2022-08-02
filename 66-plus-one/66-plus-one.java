class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            digits[i] = digits[i] + carry;
            if(digits[i]==10){
                digits[i] = 0;
                carry = 1;
            } else{
                carry = 0;
            }
        }
        if(carry==1){
            int ans[] = new int[n+1];
            ans[0] = 1;
            for(int i=0;i<n;i++){
                ans[i+1] = digits[i];
            }
            return ans;
        }
        return digits;
    }
}