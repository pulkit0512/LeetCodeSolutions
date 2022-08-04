class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int jLen = jewels.length();
        for(int i=0;i<jLen;i++){
            set.add(jewels.charAt(i));
        }
        int ans = 0;
        int sLen = stones.length();
        for(int i=0;i<sLen;i++){
            if(set.contains(stones.charAt(i))){
                ans++;
            }
        }
        return ans;
    }
}