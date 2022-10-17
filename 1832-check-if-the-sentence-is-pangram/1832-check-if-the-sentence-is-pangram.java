class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        
        int len = sentence.length();
        
        if(len<26){
            return false;
        }
        
        for(int i=0;i<len;i++){
            freq[sentence.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                return false;
            }
        }
        
        return true;
    }
}