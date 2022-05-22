class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        //System.out.println(freqMap);
        StringBuilder sb = new StringBuilder();
        int cnt[] = new int[10];
        cnt[0] = freqMap.getOrDefault('z', 0);
        cnt[2] = freqMap.getOrDefault('w', 0);
        cnt[4] = freqMap.getOrDefault('u', 0);
        cnt[6] = freqMap.getOrDefault('x', 0);
        cnt[8] = freqMap.getOrDefault('g', 0);
        cnt[5] = freqMap.getOrDefault('f', 0) - cnt[4];
        cnt[7] = freqMap.getOrDefault('s', 0) - cnt[6];
        cnt[3] = freqMap.getOrDefault('h', 0) - cnt[8];
        cnt[9] = freqMap.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];
        cnt[1] = freqMap.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];
        
        for(int i=0;i<=9;i++){
            for(int j=0;j<cnt[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}