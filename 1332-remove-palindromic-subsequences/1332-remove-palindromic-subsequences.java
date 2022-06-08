class Solution {
    public int removePalindromeSub(String s) {
        if(isPalindrome(s)){
            return 1;
        }else{
            return 2;
        }
    }
    private boolean isPalindrome(String s) {
        int len = s.length();
        int st = 0, ed = len-1;
        while(st<ed){
            if(s.charAt(st)!=s.charAt(ed)){
                return false;
            }
            st++;
            ed--;
        }
        return true;
    }
}