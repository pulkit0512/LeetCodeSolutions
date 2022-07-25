class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m<n){
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        int mc = 0;
        int st = 0, ans = m+1;
        int stIdx = -1, edIdx = -1;
        for(int i=0;i<m;i++){
            char ch = s.charAt(i);
            if(tMap.containsKey(ch)){
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if(sMap.get(ch)<=tMap.get(ch)){
                    mc++;
                }
                while(mc==n){
                    if(i-st+1<ans){
                        ans = i-st+1;
                        stIdx = st;
                        edIdx = i+1;
                    }
                    char stCh = s.charAt(st);
                    if(!sMap.containsKey(stCh)){
                        st++;
                        continue;
                    }
                    int k = sMap.get(stCh);
                    sMap.put(stCh, k-1);
                    st++;
                    if(sMap.get(stCh)<tMap.get(stCh)){
                        mc--;
                    }
                }
            }
        }
        if(stIdx==-1){
            return "";
        }
        return s.substring(stIdx, edIdx);
    }
}