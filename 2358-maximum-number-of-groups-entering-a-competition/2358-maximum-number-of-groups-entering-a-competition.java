class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        for(long i=1;i<=n;i++){
            if(i*(i+1)>2*n){
                return (int)(i-1);
            }
        }
        return 1;
    }
}