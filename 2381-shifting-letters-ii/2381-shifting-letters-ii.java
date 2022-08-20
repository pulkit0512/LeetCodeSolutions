class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char ch[] = s.toCharArray();
        int len = ch.length;
        int arr[] = new int[len+1];
        for(int[] shift:shifts){
            if(shift[2]==0){
                // If we need to move backward
                // Decrement the start of interval and increment the end of interval + 1 to nullify it's
                // effect for other indexes outside it's range.
                arr[shift[0]]--;
                arr[shift[1]+1]++;
            }else{
                // If we need to move forward
                // Increment the start of interval and decrement the end of interval + 1 to nullify it's
                // effect for other indexes outside it's range.
                arr[shift[0]]++;
                arr[shift[1]+1]--;
            }
        }
        
        // Use prefix sum to get the overall movement for current index.
        int diff = 0;
        for(int i=0;i<len;i++){
            int val = ch[i]-'a';
            diff += arr[i];
            val = ((val + diff)%26 + 26)%26;
            
            ch[i] = (char)(val+'a');
        }
        return String.valueOf(ch);
    }
}