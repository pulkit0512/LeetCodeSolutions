class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        //return UtilUsingSort(properties);
        return UtilUsingGreedy(properties);
    }
    
    private int UtilUsingGreedy(int[][] properties) {
        int n = properties.length;
        int maxAttack = 0;
        for(int i=0;i<n;i++){
            maxAttack = Math.max(maxAttack, properties[i][0]);
        }
        
        int maxDefence[] = new int[maxAttack + 2];
        for(int i=0;i<n;i++){
            maxDefence[properties[i][0]] = Math.max(maxDefence[properties[i][0]], properties[i][1]);
        }
        
        for(int i=maxAttack;i>=0;i--){
            maxDefence[i] = Math.max(maxDefence[i], maxDefence[i+1]);
        }
        
        int weak = 0;
        for(int i=0;i<n;i++){
            if(properties[i][1]<maxDefence[properties[i][0] + 1]){
                weak++;
            }
        }
        return weak;
    }
    
    private int UtilUsingSort(int[][] properties) {
        Arrays.sort(properties, (a,b) -> {
            if(a[0]==b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });
        
        //return UtilUsingStack(properties);
        return UtilUsingIteration(properties);
    }
    
    private int UtilUsingStack(int[][] properties) {
        // Using Stack
        Stack<int[]> st = new Stack<>();
        int n = properties.length;
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && st.peek()[0]<properties[i][0] && st.peek()[1]<properties[i][1]){
                while(!st.isEmpty() && st.peek()[0]<properties[i][0] && st.peek()[1]<properties[i][1]){
                    st.pop();
                }
            }
            
            st.push(properties[i]);
        }
        
        return n-st.size();
    }
    
    private int UtilUsingIteration(int[][] properties) {
        int maxDefence = 0;
        int weak = 0;
        int n = properties.length;
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