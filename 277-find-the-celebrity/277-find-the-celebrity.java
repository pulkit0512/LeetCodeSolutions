/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    // Overide the knows method to support in memory cache, it will help if this knows call is a DB call.
    private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>(); 
    
    @Override
    public boolean knows(int a, int b) {
        if (!cache.containsKey(new Pair(a, b))) {
            cache.put(new Pair(a, b), super.knows(a, b));
        }
        return cache.get(new Pair(a, b));
    }
    
    public int findCelebrity(int n) {
        //return findCelebrityN2(n);
        
        return findCelebrityN(n);
    }
    
    private int findCelebrityN(int n) {
        int celeb = 0;
        for(int i=1;i<n;i++){
            if(knows(celeb, i)){
                celeb = i;
            }
        }
        if(isCeleb(celeb, n)){
            return celeb;
        }
        return -1;
    }
    
    private int findCelebrityN2(int n) {
        for(int i=0;i<n;i++){
            if(isCeleb(i, n)){
                return i;
            }
        }
        return -1;
    }
    private boolean isCeleb(int i, int n){
        for(int j=0;j<n;j++){
            if(j==i){
                continue;
            }
            if(knows(i,j) || !knows(j,i)){
                return false;
            }
        }
        return true;
    }
}