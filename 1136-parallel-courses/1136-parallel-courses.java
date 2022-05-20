class Solution {
    class pair{
        int course, semester;
        pair(int a, int b){
            course = a;
            semester = b;
        }
    }
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> outDeg = new ArrayList<>();
        int in[] = new int[n];
        for(int i=0;i<n;i++){
            outDeg.add(new ArrayList<>());
        }
        for(int[] relation:relations){
            outDeg.get(relation[0]-1).add(relation[1]-1);
            in[relation[1]-1]++;
        }
        //System.out.println(outDeg);
        Queue<pair> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                que.add(new pair(i, 1));
            }
        }
        int ans = 0;
        List<Integer> taken = new ArrayList<>();
        while(!que.isEmpty()){
            pair temp = que.poll();
            taken.add(temp.course);
            //System.out.println(temp.course+" "+temp.semester);
            ans = Math.max(ans, temp.semester);
            for(int val:outDeg.get(temp.course)){
                in[val]--;
                if(in[val]==0){
                    que.add(new pair(val, temp.semester+1));
                }
            }
        }
        if(taken.size()==n){
            return ans;
        }else{
            return -1;
        }
    }
}