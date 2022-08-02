class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for(String word:words){
            if(isExpressive(s, word)){
                ans++;
            }
        }
        return ans;
    }
    private boolean isExpressive(String s, String word){
        int sId = 0, wId = 0;
        int sLen = s.length();
        int wLen = word.length();
        if(wLen>sLen){
            return false;
        }
        while(sId<sLen && wId<wLen){
            int sCnt = 0, wCnt = 0;
            char sCh = s.charAt(sId);
            char wCh = word.charAt(wId);
            if(sCh!=wCh){
                return false;
            }
            while(sId<sLen && s.charAt(sId)==sCh){
                sId++;
                sCnt++;
            }
            while(wId<wLen && word.charAt(wId)==wCh){
                wId++;
                wCnt++;
            }
            if(wCnt==sCnt || (sCnt>=3 && sCnt>wCnt)){
                continue;
            }else{
                return false;
            }
        }
        return sId==sLen && wId==wLen;
    }
}