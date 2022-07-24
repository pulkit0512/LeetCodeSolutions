class Solution {
    public char repeatedCharacter(String s) {
        int freq[] = new int[26];
        int len = s.length();
        char ans = 'a';
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            if(freq[ch-'a']==2){
                ans = ch;
                break;
            }
        }
        return ans;
    }
}