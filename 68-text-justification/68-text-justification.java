class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int sumLen = 0, cnt = 0, st = 0;
        for(int i=0;i<words.length;i++){
            int len = words[i].length();
            if(sumLen+len+cnt<=maxWidth){
                sumLen += len;
                cnt++;
            }else{
                ans.add(getLine(maxWidth, sumLen, st, i, cnt, words));
                st = i;
                cnt = 1;
                sumLen = len;
            }
        }
        ans.add(getLastLine(maxWidth, sumLen, st, words.length, cnt, words));
        return ans;
    }
    
    private String getLine(int maxWidth, int sumLen, int st, int i, int cnt, String[] words) {
        //System.out.println(maxWidth+" "+sumLen+" "+cnt);
        int diff = maxWidth - sumLen;
        if(cnt>1){
            cnt--;
        }
        int div = diff/cnt;
        int mod = diff%cnt;
        StringBuilder space = new StringBuilder();
        for(int j=0;j<div;j++){
            space.append(' ');
        }
        StringBuilder sb = new StringBuilder();
        while(st<i){
            sb.append(words[st++]);
            if(cnt>0){
                sb.append(space);
                cnt--;
                if(mod>0){
                    sb.append(' ');
                    mod--;
                }
            }
        }
        return sb.toString();
    }
    
    private String getLastLine(int maxWidth, int sumLen, int st, int i, int cnt, String[] words) {
        //System.out.println(maxWidth+" "+sumLen+" "+cnt);
        int diff = maxWidth - sumLen;
        cnt--;
        diff -= cnt;
        StringBuilder space = new StringBuilder();
        for(int j=0;j<diff;j++){
            space.append(' ');
        }
        StringBuilder sb = new StringBuilder();
        while(st<i){
            sb.append(words[st++]);
            if(cnt>0){
                sb.append(' ');
                cnt--;
            }
        }
        sb.append(space);
        return sb.toString();
    }
}