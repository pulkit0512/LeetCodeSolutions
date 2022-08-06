## Approach1: Using Map and Binary Search
* Need to find pairs such that i<j and j-i != nums[j] - nums[i]. We can convert this equation to j-nums[j] != i-nums[i].
* So in a map store i-nums[i] as key vs list of indexes from original array which has this key.
* Once done. Re-iterate over the original array, for each i get i-num[i] list from map.
* Binary index i in that list.
* Numbers of bad pairs for index i will be (n-i) - (list.size - index of i in map list). This is done to get all the numbers in right of i for which j-nums[j] != i-nums[i].
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
​
## Approach2: Using Map
* Need to find pairs such that i<j and j-i != nums[j] - nums[i]. We can convert this equation to j-nums[j] != i-nums[i].
* In this approach, store i-nums[i] as key vs number of times this value we got till now.
* Use map to find number of good pairs for which i-nums[i] == j-nums[j].
* Each time if i-nums[i] is repeated we get the number of good pairs we can for using current i.
* Once done finding all good pairs answer is (n*(n-1)/2)-goodPairs.
​
### Time Complexity: O(N)
### Space Complexity: O(N)