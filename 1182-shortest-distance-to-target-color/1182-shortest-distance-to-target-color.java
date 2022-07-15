class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        //return shortestDistanceColorQLogN(colors, queries);
        return shortestDistanceColorNPlusQ(colors, queries);
    }
    
    private List<Integer> shortestDistanceColorNPlusQ(int[] colors, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        int n = colors.length;
        int left[][] = new int[3][n];
        int right[][] = new int[3][n];
        int one = -1, two = -1, three = -1;
        for(int i=0;i<n;i++){
            if(colors[i]==1){
                left[0][i] = i;
                left[1][i] = two;
                left[2][i] = three;
                one = i;
            }else if(colors[i]==2){
                left[0][i] = one;
                left[1][i] = i;
                left[2][i] = three;
                two = i;
            }else{
                left[0][i] = one;
                left[1][i] = two;
                left[2][i] = i;
                three = i;
            }
        }
        one = two = three = -1;
        for(int i=n-1;i>=0;i--){
            if(colors[i]==1){
                right[0][i] = i;
                right[1][i] = two;
                right[2][i] = three;
                one = i;
            }else if(colors[i]==2){
                right[0][i] = one;
                right[1][i] = i;
                right[2][i] = three;
                two = i;
            }else{
                right[0][i] = one;
                right[1][i] = two;
                right[2][i] = i;
                three = i;
            }
        }
        
        for(int[] query:queries){
            int idx = query[0];
            int color = query[1]-1;
            int lower = left[color][idx];
            int upper = right[color][idx];
            if(lower==-1 && upper==-1){
                result.add(-1);
            }else if(lower==-1 && upper!=-1){
                result.add(upper-idx);
            }else if(lower!=-1 && upper==-1){
                result.add(idx-lower);
            }else{
                result.add(Math.min(upper-idx, idx-lower));
            }
        }
        return result;
    }
    
    private List<Integer> shortestDistanceColorQLogN(int[] colors, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer>[] colorSort= new TreeSet[3];
        for(int i=0;i<colors.length;i++){
            if(colorSort[colors[i]-1]==null){
                colorSort[colors[i]-1] = new TreeSet<>();
            }
            colorSort[colors[i]-1].add(i);
        }
        for(int[] query:queries){
            if(colors[query[0]]==query[1]){
                result.add(0);
                continue;
            }
            if(colorSort[query[1]-1]==null){
                result.add(-1);
                continue;
            }
            
            Integer upperBound = colorSort[query[1]-1].higher(query[0]);
            Integer lowerBound = colorSort[query[1]-1].lower(query[0]);
            
            if(upperBound==null && lowerBound==null){
                result.add(-1);
            }else if(upperBound==null && lowerBound!=null){
                result.add(query[0]-lowerBound);
            }else if(upperBound!=null && lowerBound==null){
                result.add(upperBound-query[0]);
            }else{
                result.add(Math.min(upperBound-query[0], query[0]-lowerBound));
            }
        }
        return result;
    }
}