class Solution {
    public String greatestLetter(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++){
            if(Character.isUpperCase(s.charAt(i))){
                upper[s.charAt(i)-'A']++;
            }else{
                lower[s.charAt(i)-'a']++;
            }
        }
        for(int i = 25;i>=0;i--){
            if(upper[i]>0 && lower[i]>0){
                return ""+(char)(i+'A');
            }
        }
        return "";
    }
}