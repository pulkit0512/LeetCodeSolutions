class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();
        int st = 0, ans = 0;
        for(int i=0;i<fruits.length;i++){
            if(freq.containsKey(fruits[i])){
                int k = freq.get(fruits[i]);
                freq.put(fruits[i], k+1);
            } else{
                if(freq.size()!=2){
                    freq.put(fruits[i], 1);
                } else{
                    ans = Math.max(ans, i-st);
                    while(freq.size()!=1){
                        //System.out.println(freq+" "+st+" "+fruits[st]);
                        int k = freq.get(fruits[st]);
                        if(k==1){
                            freq.remove(fruits[st]);
                        } else{
                            freq.put(fruits[st], k-1);
                        }
                        st++;
                    }
                    freq.put(fruits[i], 1);
                }
            }
        }
        return Math.max(ans, fruits.length-st);
    }
}