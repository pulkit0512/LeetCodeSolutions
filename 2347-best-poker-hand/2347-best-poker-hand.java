class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if(suits[0]==suits[1] && suits[1]==suits[2] && suits[2]==suits[3] && suits[3]==suits[4]){
            return "Flush";
        }
        int freq[] = new int[14];
        for(int rank:ranks){
            freq[rank]++;
        }
        boolean three = false, two = false;
        for(int i=1;i<14;i++){
            if(freq[i]>=3){
                three = true;
                break;
            }
            if(freq[i]==2){
                two = true;
            }
        }
        if(three){
            return "Three of a Kind";
        }
        if(two){
            return "Pair";
        }
        return "High Card";
    }
}