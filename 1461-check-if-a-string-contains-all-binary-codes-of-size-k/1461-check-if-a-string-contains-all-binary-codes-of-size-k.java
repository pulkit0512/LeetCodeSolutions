class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        int len = s.length();
        for(int i=0;i<=len-k;i++){
            set.add(s.substring(i, i+k));
        }
        //System.out.println(set);
        
        return set.size()==(1<<k);
    }
}