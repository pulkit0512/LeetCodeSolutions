class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int len = s.length();
        int org_k = k;
        for(char ch='A';ch<='Z';ch++){
            int st = 0;
            k = org_k;
            for(int i=0;i<len;i++){
                if(s.charAt(i)!=ch && k>0){
                    k--;
                }else if(s.charAt(i)!=ch && k==0){
                    ans = Math.max(ans, i-st);
                    while(k==0){
                        if(s.charAt(st)!=ch){
                            k++;
                        }
                        st++;
                    }
                    k--;
                }
            }
            ans = Math.max(ans, len-st);
            //System.out.println(ch+" "+ans);
        }
        return ans;
    }
}