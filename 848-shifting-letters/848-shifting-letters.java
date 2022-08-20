class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int n=shifts.length;
        shifts[n-1]=shifts[n-1]%26;
        for(int i=n-2;i>=0;i--){
            shifts[i]=(shifts[i]%26 + shifts[i+1]%26)%26;
        }
        char ch[]=S.toCharArray();
        n=ch.length;
        for(int i=0;i<n;i++){
            ch[i]=(char)(((ch[i]-'a')+shifts[i])%26+'a');
        }
        
        return String.valueOf(ch);
    }
}