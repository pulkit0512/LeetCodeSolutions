## Approach1: Using two Maps
In this question, I have used to Maps, One to store the cache key vs (value & count). Other to store freq vs set elements having that freq. And a min variable which keeps track of minimum frequency level we have in cache.
​
### get:
1. If cache doesn't contains key return -1.
2. Else we need to update the count of key by 1 and remove this key from count frequency level and add this key to count+1 frequency level.
3. If min frequency level was count and now we don't have any element at count level update min by 1 and count level from freqMap.
4. return the value of key from map.
​
### put:
1. If capacity is 0 return. To handle 0 capacity edge case.
2. If cache already contains current key update it's value and call get method to update the count and frequency map.
3. else if capacity is full evict least recently used element from lease frequently used list of freqMap and remove this element from cache as well.
4. put new key and val in cache with count as 1.
5. Update the freqMap at frequencey level 1.
6. set min frequency level as 1.
​
​
## Complexity Analysis
* **Time Complexity: O(1) for get and put**
* **Space Complexity: O(N) for frequency map.**