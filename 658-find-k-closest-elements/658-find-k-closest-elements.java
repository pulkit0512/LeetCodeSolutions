class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int st = 0, ed = arr.length-1;
        
        while(ed-st+1>k){
            if(Math.abs(x-arr[st])>Math.abs(x-arr[ed])){
                st++;
            }else{
                ed--;
            }
        }
        
        for(int i=st;i<=ed;i++){
            res.add(arr[i]);
        }
        
        return res;
    }
}