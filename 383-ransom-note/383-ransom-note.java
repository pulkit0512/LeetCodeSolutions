class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int mLen = magazine.length();
        int rLen = ransomNote.length();
        int[] chars = new int[26];
        for(int i=0;i<mLen;i++){
            char ch = magazine.charAt(i);
            chars[ch-'a']++;
        }
        for(int i=0;i<rLen;i++){
            char ch = ransomNote.charAt(i);
            if(chars[ch-'a']==0){
                return false;
            }
            chars[ch-'a']--;
        }
        return true;
    }
}