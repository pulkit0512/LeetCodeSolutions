class Solution {
    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<=len-k;i++){
            set.add(s.substring(i, i+k));
            if(set.size()==(1<<k)){
                return true;
            }
        }
        //System.out.println(set);
        
        return false;
    }
}