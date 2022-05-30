/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> nestedQue;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedQue = new LinkedList<>();
        for(NestedInteger ni : nestedList){
            populateQueue(ni);
        }
        //System.out.println(nestedQue);
    }
    
    private void populateQueue(NestedInteger ni) {
        if(ni.isInteger()){
            nestedQue.add(ni.getInteger());
        }else{
            for(NestedInteger x:ni.getList()){
                populateQueue(x);
            }
        }
    }

    @Override
    public Integer next() {
        return nestedQue.poll();
    }

    @Override
    public boolean hasNext() {
        if(nestedQue.isEmpty()){
            return false;
        }
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */