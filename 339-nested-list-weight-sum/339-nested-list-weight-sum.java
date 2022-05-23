/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        //return recursiveHelper(nestedList, 1);
        return BFSHelper(nestedList);
    }
    private int BFSHelper(List<NestedInteger> nestedList) {
        Queue<NestedInteger> que = new LinkedList<>();
        que.addAll(nestedList);
        int depth = 1, sum = 0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                NestedInteger ni = que.poll();
                Integer val = ni.getInteger();
                if(val!=null){
                    sum += val*depth;
                }
                List<NestedInteger> list = ni.getList();
                if(list!=null){
                    que.addAll(list);
                }
            }
            depth++;
        }
        return sum;
    }
    
    private int recursiveHelper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(NestedInteger ni:nestedList){
            Integer val = ni.getInteger();
            if(val!=null){
                sum += depth*val;
            }
            List<NestedInteger> list = ni.getList();
            if(list!=null){
                sum += recursiveHelper(list, depth+1);
            }
        }
        return sum;
    }
}