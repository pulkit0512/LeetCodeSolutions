class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>(k);
        int st = 0, ed = arr.length-1;
        while(ed-st+1>k){
            if(Math.abs(arr[st]-x)<=Math.abs(arr[ed]-x)){
                ed--;
            }else{
                st++;
            }
        }
        
        for(int i=st;i<=ed;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}