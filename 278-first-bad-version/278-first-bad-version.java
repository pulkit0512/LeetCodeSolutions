/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int first = 1, last = n;
        int ans = -1;
        while(first<=last){
            int mid = first + (last-first)/2;
            boolean isBad = isBadVersion(mid);
            //System.out.println(mid+" "+isBad);
            if(isBad){
                last = mid-1;
                ans = mid;
            }else{
                first = mid+1;
            }
        }
        return ans;
    }
}