class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String domain:cpdomains){
            int space = domain.indexOf(' ');
            int count = Integer.valueOf(domain.substring(0, space));
            domain = domain.substring(space+1);
            while(!domain.isEmpty()){
                if(!map.containsKey(domain)){
                    map.put(domain, 0);
                }
                map.put(domain, map.get(domain) + count);
                int idx = domain.indexOf('.');
                if(idx==-1){
                    domain = "";
                }else{
                    domain = domain.substring(idx+1);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            ans.add(entry.getValue()+" "+entry.getKey());
        }
        return ans;
    }
}