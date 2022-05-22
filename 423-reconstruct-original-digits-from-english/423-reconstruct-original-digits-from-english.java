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
        cnt[0] = check(freqMap, 'z', "zero", 4);
        cnt[2] = check(freqMap, 'w', "two", 3);
        cnt[4] = check(freqMap, 'u', "four", 4);
        cnt[1] = check(freqMap, 'o', "one", 3);
        cnt[5] = check(freqMap, 'f', "five", 4);
        cnt[6] = check(freqMap, 'x', "six", 3);
        cnt[7] = check(freqMap, 's', "seven", 5);
        cnt[8] = check(freqMap, 'g', "eight", 5);
        cnt[9] = check(freqMap, 'i', "nine", 4);
        cnt[3] = check(freqMap, 't', "three", 5);
        
        for(int i=0;i<=9;i++){
            for(int j=0;j<cnt[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
    
    private int check(Map<Character, Integer> freqMap, char ch, String s, int len){
        if(freqMap.isEmpty() || !freqMap.containsKey(ch)){
            return 0;
        }
        int val = freqMap.get(ch);
        for(int i=0;i<len;i++){
            char temp = s.charAt(i);
            int k = freqMap.get(temp);
            if(k==val){
                freqMap.remove(temp);
            }else{
                freqMap.put(temp, k-val);
            }
        }
        return val;
    }
}