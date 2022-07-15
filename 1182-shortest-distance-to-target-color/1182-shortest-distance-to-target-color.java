class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer>[] colorSort= new TreeSet[3];
        colorSort[0] = new TreeSet<>();
        colorSort[1] = new TreeSet<>();
        colorSort[2] = new TreeSet<>();
        for(int i=0;i<colors.length;i++){
            colorSort[colors[i]-1].add(i);
        }
        //System.out.println(colorSort[0]);
        //System.out.println(colorSort[1]);
        //System.out.println(colorSort[2]);
        for(int[] query:queries){
            if(colors[query[0]]==query[1]){
                result.add(0);
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