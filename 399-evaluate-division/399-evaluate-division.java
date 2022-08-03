class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //return calcEquationUnionFind(equations, values, queries);
        return calcEquationDFS(equations, values, queries);
    }
    
    // DFS
    private double[] calcEquationDFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Create a graph, where each dividend as key will have a map of all the divisor vs dividend/divisor value
        // And each divisor as key will have a map of all the dividend vs divisor/dividend value.
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // Step1: Build Graph
        for(int i=0;i<equations.size();i++) {
            String divid = equations.get(i).get(0);
            String divis = equations.get(i).get(1);
            if(!graph.containsKey(divid)){
                graph.put(divid, new HashMap<>());
            }
            if(!graph.containsKey(divis)){
                graph.put(divis, new HashMap<>());
            }
            
            graph.get(divid).put(divis, values[i]);
            graph.get(divis).put(divid, 1/values[i]);
        }
        
        // Step2: DFS
        double[] ans = new double[queries.size()];
        Set<String> visited = new HashSet<>();
        for(int i=0;i<queries.size();i++){
            String divid = queries.get(i).get(0);
            String divis = queries.get(i).get(1);
            
            if(!graph.containsKey(divid) || !graph.containsKey(divis)){
                ans[i] = -1.0;
            }else if(divid.equals(divis)){
                ans[i] = 1.0;
            }else{
                ans[i] = dfs(graph, divid, divis, 1, visited);
            }
        }
        
        return ans;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String src, String tar, double prd, Set<String> visited) {
        if(src.equals(tar)){
            return prd;
        }
        
        visited.add(src);
        double ret = -1;
        
        Map<String, Double> neigh = graph.get(src);
        for(Map.Entry<String, Double> entry:neigh.entrySet()){
            if(!visited.contains(entry.getKey())){
                ret = dfs(graph, entry.getKey(), tar, prd * entry.getValue(), visited);
                if(ret != -1){
                    break;
                }
            }
        }
        
        visited.remove(src);
        return ret;
    }
    
    
    // Union Find Method.
    private double[] calcEquationUnionFind(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Pair<String, Double>> graph = new HashMap<>();
        for(int i=0;i<values.length;i++){
            union(graph, equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double res[] = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            if(!graph.containsKey(queries.get(i).get(0)) || !graph.containsKey(queries.get(i).get(1))){
                res[i] = -1.0;
                continue;
            }
            Pair<String, Double> p1 = find(graph, queries.get(i).get(0));
            Pair<String, Double> p2 = find(graph, queries.get(i).get(1));
            if(!p1.getKey().equals(p2.getKey())){
                res[i] = -1.0;
            }else{
                res[i] = p1.getValue()/p2.getValue();
            }
        }
        return res;
    }
    private void union(Map<String, Pair<String, Double>> graph, String divid, String divis, double val){
        Pair<String, Double> p1 = find(graph, divid);
        Pair<String, Double> p2 = find(graph, divis);
        
        if(!p1.getKey().equals(p2.getKey())){
            graph.put(p1.getKey(), new Pair(p2.getKey(), p2.getValue() * val / p1.getValue()));
        }
    }
    private Pair<String, Double> find(Map<String, Pair<String, Double>> graph, String id){
        if(!graph.containsKey(id)){
            graph.put(id, new Pair(id, 1.0));
        }
        Pair<String, Double> p = graph.get(id);
        if(!p.getKey().equals(id)){
            Pair<String, Double> newPair = find(graph, p.getKey());
            graph.put(id, new Pair(newPair.getKey(), newPair.getValue() * p.getValue()));
        }
        return graph.get(id);
    }
}