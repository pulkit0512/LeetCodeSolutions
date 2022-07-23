class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int roll:rolls){
            set.add(roll);
            if(set.size()==k){
                st.push(roll);
                set.clear();
            }
        }
        return st.size()+1;
    }
}