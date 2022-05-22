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
        cnt[0] = check(freqMap, 'z', "zero");
        cnt[2] = check(freqMap, 'w', "two");
        cnt[4] = check(freqMap, 'u', "four");
        cnt[1] = check(freqMap, 'o', "one");
        cnt[5] = check(freqMap, 'f', "five");
        cnt[6] = check(freqMap, 'x', "six");
        cnt[7] = check(freqMap, 's', "seven");
        cnt[8] = check(freqMap, 'g', "eight");
        cnt[9] = check(freqMap, 'i', "nine");
        cnt[3] = check(freqMap, 't', "three");
        
        for(int i=0;i<=9;i++){
            for(int j=0;j<cnt[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
    
    private int check(Map<Character, Integer> freqMap, char ch, String s){
        if(freqMap.isEmpty() || !freqMap.containsKey(ch)){
            return 0;
        }
        int val = freqMap.get(ch);
        int len = s.length();
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