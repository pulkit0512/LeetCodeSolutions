class Solution {
    public int longestPalindrome(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                upper[ch-'A']++;
            }else{
                lower[ch-'a']++;
            }
        }
        boolean isLowerOdd = false, isUpperOdd = false;
        int lSize = 0, uSize = 0;
        for(int i=0;i<26;i++){
            if(lower[i]%2==1){
                isLowerOdd = true;
            }
            if(upper[i]%2==1){
                isUpperOdd = true;
            }
            lSize += (lower[i]/2)*2;
            uSize += (upper[i]/2)*2;
        }
        if(isLowerOdd || isUpperOdd){
            return lSize + uSize + 1;
        }
        
        return lSize+uSize;
    }
}