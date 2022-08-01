class Solution {
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] perm = new int[len+1];
        int val = 1;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch=='I'){
                perm[i] = val;
                val++;
            }else{
                int idx = i;
                while(i<len && s.charAt(i)=='D'){
                    val++;
                    i++;
                }
                for(int j=idx;j<=i;j++){
                    perm[j] = val;
                    val--;
                }
                val = perm[idx] + 1;
            }
        }
        if(s.charAt(len-1)=='D'){
            perm[len] = perm[len-1] - 1;
        }else{
            perm[len] = val;
        }
        return perm;
    }
}