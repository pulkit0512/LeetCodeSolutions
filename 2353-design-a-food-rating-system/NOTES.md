## Approach:
* Created two maps, one for food vs (rating, cuisine) and other for cuisine vs TreeSet of food_rating.
* Implemented custom comparator on treeset based on given rules.
* For change rating fetched the food data from food map. for that data changed the food rating in cuisine map and updated food map as well with latest rating.
* For highest rated fetched the first element from given cuisine set and return the food from food_rating string.
​
### Time Complexity:
#### FoodRatings Constructor: O(NLogN)
#### changeRating: O(LogN)
#### highestRated: O(1)
​
### Space Complexity: O(N)