class Solution {
    Map<String, List<String>> graph;
    Set<String> visited;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();
        for(List<String> account:accounts){
            if(!graph.containsKey(account.get(1))){
                graph.put(account.get(1), new ArrayList<>());
            }
            for(int i=2;i<account.size();i++){
                graph.get(account.get(1)).add(account.get(i));
                if(!graph.containsKey(account.get(i))){
                    graph.put(account.get(i), new ArrayList<>());
                }
                graph.get(account.get(i)).add(account.get(1));
            }
        }
        for(List<String> account:accounts){
            if(!visited.contains(account.get(1))){
                List<String> userAccount = new ArrayList<>();
                userAccount.add(account.get(0));
                dfs(userAccount, account.get(1));
                Collections.sort(userAccount.subList(1, userAccount.size()));
                mergedAccounts.add(userAccount);
            }
        }
        return mergedAccounts;
    }
    
    private void dfs(List<String> userAccount, String email) {
        if(visited.contains(email)){
            return;
        }
        visited.add(email);
        userAccount.add(email);
        List<String> neighbours = graph.get(email);
        for(String neighbour:neighbours){
            dfs(userAccount, neighbour);
        }
    }
}