class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        //return shortestDistanceColorQLogN(colors, queries);
        return shortestDistanceColorNPlusQ(colors, queries);
    }
    
    private List<Integer> shortestDistanceColorNPlusQ(int[] colors, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        int n = colors.length;
        int dist[][] = new int[3][n];
        int one = -1, two = -1, three = -1;
        for(int i=0;i<n;i++){
            if(colors[i]==1){
                dist[1][i] = (two==-1)?Integer.MAX_VALUE:i-two;
                dist[2][i] = (three==-1)?Integer.MAX_VALUE:i-three;
                one = i;
            }else if(colors[i]==2){
                dist[0][i] = (one==-1)?Integer.MAX_VALUE:i-one;
                dist[2][i] = (three==-1)?Integer.MAX_VALUE:i-three;
                two = i;
            }else{
                dist[0][i] = (one==-1)?Integer.MAX_VALUE:i-one;
                dist[1][i] = (two==-1)?Integer.MAX_VALUE:i-two;
                three = i;
            }
        }
        one = two = three = -1;
        for(int i=n-1;i>=0;i--){
            if(colors[i]==1){
                dist[1][i] = Math.min(dist[1][i], (two==-1)?Integer.MAX_VALUE:two-i);
                dist[2][i] = Math.min(dist[2][i], (three==-1)?Integer.MAX_VALUE:three-i);
                one = i;
            }else if(colors[i]==2){
                dist[0][i] = Math.min(dist[0][i], (one==-1)?Integer.MAX_VALUE:one-i);
                dist[2][i] = Math.min(dist[2][i], (three==-1)?Integer.MAX_VALUE:three-i);
                two = i;
            }else{
                dist[0][i] = Math.min(dist[0][i], (one==-1)?Integer.MAX_VALUE:one-i);
                dist[1][i] = Math.min(dist[1][i], (two==-1)?Integer.MAX_VALUE:two-i);
                three = i;
            }
        }
        
        for(int[] query:queries){
            int idx = query[0];
            int color = query[1]-1;
            int val = (dist[color][idx]==Integer.MAX_VALUE)?-1:dist[color][idx];
            result.add(val);
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