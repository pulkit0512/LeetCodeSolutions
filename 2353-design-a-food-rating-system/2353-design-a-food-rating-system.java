class FoodRatings {
    // food vs cuisine, ratings
    // cuisine vs food_ratings
    class Sort implements Comparator<String> {
        public int compare(String a, String b) {
            int a_idx = a.indexOf("_");
            int b_idx = b.indexOf("_");
            int a_rating = Integer.valueOf(a.substring(a_idx+1));
            int b_rating = Integer.valueOf(b.substring(b_idx+1));
            String a_food = a.substring(0, a_idx);
            String b_food = b.substring(0, b_idx);
            
            if(a_rating==b_rating){
                return a_food.compareTo(b_food);
            }
            return b_rating - a_rating;
        }
    }

    Map<String, Pair<Integer, String>> foodMap;
    Map<String, TreeSet<String>> cuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        int n = foods.length;
        for(int i=0;i<n;i++){
            foodMap.put(foods[i], new Pair(ratings[i], cuisines[i]));
            if(!cuisineMap.containsKey(cuisines[i])){
                cuisineMap.put(cuisines[i], new TreeSet<>(new Sort()));
            }
            cuisineMap.get(cuisines[i]).add(foods[i]+"_"+ratings[i]);
        }
        //System.out.println(cuisineMap);
    }
    
    public void changeRating(String food, int newRating) {
        //System.out.println(food+"_"+newRating);
        Pair<Integer, String> foodData = foodMap.get(food);
        cuisineMap.get(foodData.getValue()).remove(food+"_"+foodData.getKey());
        cuisineMap.get(foodData.getValue()).add(food+"_"+newRating);
        foodMap.put(food, new Pair(newRating, foodData.getValue()));
        //System.out.println(cuisineMap);
    }
    
    public String highestRated(String cuisine) {
        //System.out.println(cuisine);
        String food_rating = cuisineMap.get(cuisine).first();
        int idx = food_rating.indexOf("_");
        return food_rating.substring(0, idx);
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */