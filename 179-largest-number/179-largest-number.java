class Solution {
    class Sort implements Comparator<String> {
        public int compare(String a, String b) {
            String x = a+b;
            String y = b+a;
            
            return y.compareTo(x);
        }
    }
    public String largestNumber(int[] nums) {
        List<String> numStrings = IntStream.of(nums)
                .mapToObj(String::valueOf)
                .sorted(new Sort())
                .collect(Collectors.toList());
        
        // If, after being sorted, the largest number is `0`, the entire number is zero.
        if(numStrings.get(0).equals("0")){
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        for(String num:numStrings){
            res.append(num);
        }
        
        return res.toString();
    }
}