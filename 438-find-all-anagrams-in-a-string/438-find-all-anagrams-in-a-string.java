class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if(sLen<pLen){
            return result;
        }
        int[] pFreq = new int[26];
        for(int i=0;i<pLen;i++){
            pFreq[p.charAt(i)-'a']++;
        }
        int[] sFreq = new int[26];
        int st = 0, ans = 0;
        for(int i=0;i<=sLen;i++){
            if(i<pLen){
                sFreq[s.charAt(i)-'a']++;
            }else{
                boolean anagram = true;
                for(int j=0;j<26;j++){
                    if(sFreq[j]!=pFreq[j]){
                        anagram = false;
                        break;
                    }
                }
                if(anagram){
                    result.add(st);
                }
                if(i<sLen){
                    sFreq[s.charAt(st)-'a']--;
                    sFreq[s.charAt(i)-'a']++;
                    st++;
                }
            }
        }
        return result;
    }
}