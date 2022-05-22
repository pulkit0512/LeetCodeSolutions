class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int len = s.length();
        int arr[] = new int[26];
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        //System.out.println(freqMap);
        StringBuilder sb = new StringBuilder();
        int cnt[] = new int[10];
        cnt[0] = arr['z'-'a'];
        cnt[2] = arr['w'-'a'];
        cnt[4] = arr['u'-'a'];
        cnt[6] = arr['x'-'a'];
        cnt[8] = arr['g'-'a'];
        cnt[5] = arr['f'-'a'] - cnt[4];
        cnt[7] = arr['s'-'a'] - cnt[6];
        cnt[3] = arr['h'-'a'] - cnt[8];
        cnt[9] = arr['i'-'a'] - cnt[5] - cnt[6] - cnt[8];
        cnt[1] = arr['o'-'a'] - cnt[0] - cnt[2] - cnt[4];
        
        for(int i=0;i<=9;i++){
            for(int j=0;j<cnt[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}