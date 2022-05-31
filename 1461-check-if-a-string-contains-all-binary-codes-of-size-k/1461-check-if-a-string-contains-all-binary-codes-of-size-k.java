class Solution {
    public boolean hasAllCodes(String s, int k) {
        //return hasAllCodesUsingSet(s, k);
        return hasAllCodesUsingRollingHash(s, k);
    }
    
    private boolean hasAllCodesUsingRollingHash(String s, int k) {
        int total = (1<<k);
        boolean[] hash = new boolean[total];
        int hashVal = 0;
        int all1 = total-1;
        int len = s.length();
        for(int i=0; i<len;i++){
            hashVal = ((hashVal<<1) & all1) | (s.charAt(i)-'0');
            if(i>=k-1 && !hash[hashVal]){
                hash[hashVal] = true;
                total--;
                if(total==0){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean hasAllCodesUsingSet(String s, int k) {
        int len = s.length();
        if(len<(1<<k)){
            return false;
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<=len-k;i++){
            set.add(s.substring(i, i+k));
            if(set.size()==(1<<k)){
                return true;
            }
        }
        
        return false;
    }
}