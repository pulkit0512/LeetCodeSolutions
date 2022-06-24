class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 2*n;
        Map<Integer, int[]> cinema = new HashMap<>();
        for(int[] seat:reservedSeats){
            if(!cinema.containsKey(seat[0])){
                cinema.put(seat[0], new int[10]);
            }
            cinema.get(seat[0])[seat[1]-1] = 1;
        }
        for(int row:cinema.keySet()){
            int val[] = cinema.get(row);
            int temp = 2;
            if(val[1]==1 || val[2]==1 || val[3]==1 || val[4]==1){
                temp--;
            }
            if(val[5]==1 || val[6]==1 || val[7]==1 || val[8]==1){
                temp--;
            }
            if(temp==0 && val[3]==0 && val[4]==0 && val[5]==0 && val[6]==0){
                temp++;
            }
            ans = ans - (2-temp);
        }
        return ans;
    }
}