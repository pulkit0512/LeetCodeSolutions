* **Approach:** In this question, Used map store the sum I have seen till and the count of that sum. After adding a nums[i] to sum if map contains sum-k then in add the count of sum-k from map. This is done because sum-k contains the count of subarrays with sum as k.
* Increment the sum counter in the map if already exist if not add a new entry to map. In begining add entry of 0 with count as 1.
​
* The idea behind this approach is as follows: If the cumulative sum(represented by sum[i] for sum up to ith index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i] - sum[j] = k, the sum of elements lying between indices i and j is k.
​
* **Complexity Analysis**
​
* **Time complexity : O(n).** The entire nums array is traversed only once.
​
* **Space complexity : O(n).** Hashmap map can contain up to n distinct entries in the worst case.