class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
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