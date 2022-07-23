class NumberContainers {

    Map<Integer, TreeSet<Integer>> numberMap;
    Map<Integer, Integer> indexMap;
    public NumberContainers() {
        numberMap = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexMap.containsKey(index)){
            int prev = indexMap.get(index);
            if(prev==number){
                return;
            }
            numberMap.get(prev).remove(index);
        }
        indexMap.put(index, number);
        if(!numberMap.containsKey(number)){
            numberMap.put(number, new TreeSet<>());
        }
        numberMap.get(number).add(index);
    }
    
    public int find(int number) {
        if(numberMap.containsKey(number) && numberMap.get(number).size()!=0){
            return numberMap.get(number).first();
        }else{
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */