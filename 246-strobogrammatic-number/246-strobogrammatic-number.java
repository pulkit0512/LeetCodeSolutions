class Solution {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        int st = 0, ed = len-1;
        while(st<=ed){
            if((num.charAt(st)=='6' && num.charAt(ed)=='9') || (num.charAt(st)=='9' && num.charAt(ed)=='6') ||
              (num.charAt(st)=='0' && num.charAt(ed)=='0') || (num.charAt(st)=='1' && num.charAt(ed)=='1') || 
              (num.charAt(st)=='8' && num.charAt(ed)=='8')){
                st++;
                ed--;
            }else{
                return false;
            }
        }
        return true;
    }
}