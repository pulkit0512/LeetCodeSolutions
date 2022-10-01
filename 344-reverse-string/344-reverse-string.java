class Solution {
    public void reverseString(char[] s) {
        int st = 0, ed = s.length-1;
        
        while(st<ed){
            char temp = s[st];
            s[st] = s[ed];
            s[ed] = temp;
            st++;
            ed--;
        }
    }
}