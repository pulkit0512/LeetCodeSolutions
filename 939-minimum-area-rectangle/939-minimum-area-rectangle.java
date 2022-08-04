class Solution {
    //O(N^3) solution find forth point using set
    /*class sort implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        }
    }
    public int minAreaRect(int[][] points) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(points, new sort());
        Set<String> set = new HashSet<>();
        for(int[] point:points){
            set.add(point[0]+"$"+point[1]);
        }
        //System.out.println();
        for(int i=0;i<points.length;i++){
            String pointI = points[i][0]+"$"+points[i][1];
            set.remove(pointI);
            for(int j=i+1;j<points.length;j++){
                if(points[i][0]==points[j][0]){
                    String pointJ = points[j][0]+"$"+points[j][1];
                    set.remove(pointJ);
                    for(int k=j+1;k<points.length;k++){
                        if(points[k][1]==points[j][1]){
                            String pointK = points[k][0]+"$"+points[k][1];
                            set.remove(pointK);
                            //System.out.println(pointI+" "+pointJ+" "+pointK);
                            if(set.contains(points[k][0]+"$"+points[i][1])){
                                int area = (points[j][1]-points[i][1])*(points[k][0]-points[j][0]);
                                min = Math.min(min, area);
                            }
                            set.add(pointK);
                        }
                    }
                    set.add(pointJ);
                }
            }
            set.add(pointI);
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }*/
    
    //O(N^2) approach using map and finding two opposite points using loops and other two points using map
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] point:points){
            if(!map.containsKey(point[0])){
                map.put(point[0], new HashSet());
            }
            map.get(point[0]).add(point[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int[] p1:points){
            for(int[] p2:points){
                if(p1[0]==p2[0] || p1[1]==p2[1]){
                    continue;
                }
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])){
                    min = Math.min(min, Math.abs((p2[1]-p1[1])*(p2[0]-p1[0])));
                }
            }
        }
        return (min!=Integer.MAX_VALUE)?min:0;
    }
}