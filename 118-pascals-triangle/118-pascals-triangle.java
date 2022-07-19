class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(pascalTriangle.get(i-1).get(j-1) + pascalTriangle.get(i-1).get(j));
            }
            row.add(1);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
}