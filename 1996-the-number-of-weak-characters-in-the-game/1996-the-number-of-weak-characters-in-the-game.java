class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a,b) -> {
            if(a[0]==b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });
        
        int n = properties.length;
        
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && st.peek()[0]<properties[i][0] && st.peek()[1]<properties[i][1]){
                while(!st.isEmpty() && st.peek()[0]<properties[i][0] && st.peek()[1]<properties[i][1]){
                    st.pop();
                }
                st.push(properties[i]);
            }else{
                st.push(properties[i]);
            }
        }
        
        return n-st.size();
    }
}