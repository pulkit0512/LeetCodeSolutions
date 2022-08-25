class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int len = s.length();
        int org_k = k;
        int arr[] = new int[26];
        for(int i=0;i<len;i++){
            arr[s.charAt(i)-'A']++;
        }
        for(char ch='A';ch<='Z';ch++){
            if(arr[ch-'A']==0){
                continue;
            }
            int st = 0;
            k = org_k;
            for(int i=0;i<len;i++){
                if(s.charAt(i)==ch){
                    continue;
                }
                if(k>0){
                    k--;
                }else{
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
        }
        return ans;
    }
}