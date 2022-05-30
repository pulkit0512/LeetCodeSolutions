## Approach1: Using HashMap
During initialization, stored val with all it's indexes in map. Then during pick function call fetched the list from map for target and randomly picked one index out of it.
​
### Complexity Analysis
​
* **Time Complexity**
* If N represents the size of the nums array, building indices takes O(N) time.
* pick method takes O(1) time.
​
* **Space Complexity: O(N) required for indices.**
​
## Approach2: Reservoir Sampling
This approach works only on number of pick calls or array size is less. For each call pick function will take O(N) complexity since we will iterate over entire array.
​
#### Reservoir Sampling
* This can be interpreted as
* Picking the ith number from the list of i numbers
* Not picking the (i+1)th number from the list of (i+1) numbers. Hence picking any of the remaining i numbers.
​
* And so on ...
​
* Not picking the (n)th number from the list of (n) numbers. Hence picking any of the remaining (n−1) numbers.
​
### Algorithm
1. Iterate over the nums array for each pick call.
2. if nums[i] is equal to target, i is a potential candidate which needs to be chosen uniformly at random.
3. increment the count of total candidates available to be chosen uniformly at random.
4. pick the current number with probability (1 / count) **[reservoir sampling]**
5. return index.
​
### Complexity Analysis
​
* **Time Complexity: If N represents the size of the nums array, pick method takes O(N) time**
* **Space Complexity: O(1)**