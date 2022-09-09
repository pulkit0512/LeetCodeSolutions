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
        
        // Using Stack
        /*Stack<int[]> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && st.peek()[0]<properties[i][0] && st.peek()[1]<properties[i][1]){
                while(!st.isEmpty() && st.peek()[0]<properties[i][0] && st.peek()[1]<properties[i][1]){
                    st.pop();
                }
            }
            
            st.push(properties[i]);
        }
        
        return n-st.size();*/
        
        int maxDefence = 0;
        int weak = 0;
        // Sort on atack in ascending order and in case of tie sort on defence in descending order.
        // Sorting defence in descending order will help in case of tie from right to left we will
        // get lower defence first for same attacks.
        // so for lower attacks we will get max defence for higher attacks and will get all weak properties.
        for(int i=n-1;i>=0;i--){
            if(properties[i][1]<maxDefence){
                weak++;
            }
            
            maxDefence = Math.max(maxDefence, properties[i][1]);
        }
        
        return weak;
    }
}