class Solution {
    public String getHint(String secret, String guess) {
        int x = 0, y = 0;
        int len = secret.length();
        int[] map = new int[10];
        for(int i=0;i<len;i++){
            char ch = secret.charAt(i);
            if(ch==guess.charAt(i)){
                x++;
                continue;
            }
            map[ch-'0']++;
        }
        for(int i=0;i<len;i++){
            char ch = guess.charAt(i);
            if(ch==secret.charAt(i)){
                continue;
            }
            if(map[ch-'0']!=0){
                y++;
                map[ch-'0']--;
            }
        }
        return x+"A"+y+"B";
    }
}