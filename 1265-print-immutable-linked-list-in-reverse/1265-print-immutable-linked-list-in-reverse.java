/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        //printNSpace(head);
        printSqrtNSpace(head);
    }
    
    // O(N) Time, O(N) Space
    private void printNSpace(ImmutableListNode head) {
        if(head==null){
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
    
    // O(N) Time, O(Sqrt(N)) Space
    private void printSqrtNSpace(ImmutableListNode head) {
        int count = getCount(head);
        int chunksSize = (int)Math.ceil(Math.sqrt(count));
        List<ImmutableListNode> chunks = new ArrayList<>();
        ImmutableListNode temp = head;
        for(int i=0;i<count;i++) {
            if(i%chunksSize==0){
                chunks.add(temp);
            }
            temp = temp.getNext();
        }
        for(int i=chunks.size()-1;i>=0;i--) {
            Stack<ImmutableListNode> st = new Stack<>();
            ImmutableListNode current = chunks.get(i);
            for(int j=0;j<chunksSize && current!=null;j++){
                st.push(current);
                current = current.getNext();
            }
            while(!st.isEmpty()){
                st.pop().printValue();
            }
        }
    }
    private int getCount(ImmutableListNode head){
        int cnt = 0;
        ImmutableListNode temp = head;
        while(temp!=null){
            cnt++;
            temp = temp.getNext();
        }
        return cnt;
    }
}