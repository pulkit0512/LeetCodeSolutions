class Solution {
    public boolean isRobotBounded(String instructions) {
        int step = 0;
        int n = instructions.length();
        //0 = north, 1 = east, 2 = south, 3 = west
        int dir = 0;
        for(int i=0, cycle=1;i<n && cycle<=4;i++){
            if(instructions.charAt(i)=='G'){
                if(dir==0 || dir==1){
                    step++;
                }else{
                    step--;
                }
            }else if(instructions.charAt(i)=='L'){
                dir = (dir+3)%4;
            }else{
                dir = (dir+1)%4;
            }
            if(i+1==n){
                if(step==0){
                    return true;
                }
                i=-1;
                cycle++;
            }
        }
        return false;
    }
}