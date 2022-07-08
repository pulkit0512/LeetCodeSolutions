class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int st = 0, ed = len-1;
        while(st<=ed){
            while(st<len && !Character.isLetterOrDigit(s.charAt(st))){
                st++;
            }
            while(ed>=0 && !Character.isLetterOrDigit(s.charAt(ed))){
                ed--;
            }
            if(st>ed){
                break;
            }
            char left = Character.toLowerCase(s.charAt(st));
            char right = Character.toLowerCase(s.charAt(ed));
            if(left!=right){
                return false;
            }else{
                st++;
                ed--;
            }
        }
        return true;
    }
}