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
        
        StringBuilder res = new StringBuilder();
        for(String num:numStrings){
            res.append(num);
        }
        
        if(allZero(res)){
            return "0";
        }else{
            return res.toString();
        }
    }
    
    private boolean allZero(StringBuilder sb) {
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='0'){
                return false;
            }
        }
        
        return true;
    }
}