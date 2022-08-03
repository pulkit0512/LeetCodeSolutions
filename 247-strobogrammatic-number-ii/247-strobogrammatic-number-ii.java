class Solution {
    Map<Integer, List<String>> map;
    public List<String> findStrobogrammatic(int n) {
        initailizeMap();
        return helper(n);
    }
    private List<String> helper(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        List<String> newList = new ArrayList<>();
        List<String> list1, list2;
        int len;
        if(n%2==0){
            list1 = helper(n-2);
            list2 = map.get(2);
            len = (n-2)/2;
        }else{
            list1 = helper(n-1);
            list2 = map.get(1);
            len = (n-1)/2;
        }
        for(String s1:list1){
            String sub1 = s1.substring(0, len);
            String sub2 = s1.substring(len);
            if(n%2==0){
                newList.add(sub1+"00"+sub2);
            }
            for(String s2:list2){
                String newStr = sub1+s2+sub2;
                newList.add(newStr);
            }
        }
        map.put(n, newList);
        return newList;
    }
    private void initailizeMap(){
        if(map==null){
            map = new HashMap<>();
            List<String> one = new ArrayList<>();
            one.add("0");
            one.add("1");
            one.add("8");
            List<String> two = new ArrayList<>();
            two.add("11");
            two.add("69");
            two.add("88");
            two.add("96");
            map.put(1, one);
            map.put(2, two);
        }
    }
}