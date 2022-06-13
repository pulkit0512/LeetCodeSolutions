class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for(int i=len-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }
}