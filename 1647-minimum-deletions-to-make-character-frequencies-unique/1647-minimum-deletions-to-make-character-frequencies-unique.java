class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int ans = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            freq[s.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        for(int i=24;i>=0;i--){
            if(freq[i]==0){
                break;
            }
            if(freq[i]>=freq[i+1]){
                int newVal = Math.max(0,freq[i+1]-1);
                ans = ans + (freq[i]-newVal);
                freq[i] = newVal;
            }
        }
        return ans;
    }
}