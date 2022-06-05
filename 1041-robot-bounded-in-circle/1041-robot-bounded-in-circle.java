class Solution {
    // With atmost 4 iterations we can check if it is forming a cycle or not.
    // If after any iteration steps is 0 then return true.
    // If after exhausting all the 4 cycles if we don't get steps as 0 then return false.
    // we can solve it in Single cycle as well, if after the cycle is completed if steps is 0 or dir is not north
    // then cycle exist else false.
    public boolean isRobotBounded(String instructions) {
        int step = 0;
        int n = instructions.length();
        //0 = north, 1 = east, 2 = south, 3 = west
        int dir = 0;
        //for(int i=0, cycle=1;i<n && cycle<=4;i++){
        for(int i=0;i<n;i++){
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
            /*if(i+1==n){
                if(step==0){
                    return true;
                }
                i=-1;
                cycle++;
            }*/
        }
        return step==0 || dir!=0;
    }
}