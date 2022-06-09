class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int st = 0, ed = numbers.length-1;
        while(st<ed){
            if(numbers[st]+numbers[ed]==target){
                break;
            }else if(numbers[st]+numbers[ed]>target){
                ed--;
            }else{
                st++;
            }
        }
        ans[0] = st+1;
        ans[1] = ed+1;
        return ans;
    }
}