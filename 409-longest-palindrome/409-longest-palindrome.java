class Solution {
    public int longestPalindrome(String s) {
        int[] fMap = new int[52];
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                fMap[26 + ch-'A']++;
            }else{
                fMap[ch-'a']++;
            }
        }
        boolean isOdd = false;
        int size = 0;
        for(int i=0;i<52;i++){
            if(fMap[i]%2==1){
                isOdd = true;
            }
            size += (fMap[i]/2)*2;
        }
        if(isOdd){
            return size + 1;
        }
        
        return size;
    }
}