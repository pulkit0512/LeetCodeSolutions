/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Set<Integer> notCeleb = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(knows(i,j)){
                    notCeleb.add(i);
                }else{
                    notCeleb.add(j);
                }
            }
        }
        int ans = -1;
        for(int i=0;i<n;i++){
            if(!notCeleb.contains(i)){
                if(ans!=-1){
                    return -1;
                }
                ans = i;
            }
        }
        return ans;
    }
}