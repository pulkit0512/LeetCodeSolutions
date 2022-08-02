## Approach:
* DP with TreeMap of value vs index.
* Also we will use two boolean arrays odd and even to keep track of jumps i.e. if we take even jump from current element to next wether the odd jump from that will result in reaching end or not. Similarly the case for odd jump from current element to next wether the even jump from next will result in reaching end or not.
* Start from right to left. Rightmost element will always result in an answer since we are already at the end and no jumps needed.
* Store the value and it's index in the map. And odd[n-1] = even[n-1] = true.
* Now iterating over the array from right to left. Fetch the ceil and floor key from tree map.
* If from ceil key we can take an even jump so that it reaches to end then we can take odd jump from this key to ceil key. Set odd[i] = true.
* If from floor key we take an odd jump so that it reaches to end then we can take even jum from this key to floor key. Set even[i] = true.
* Store the value vs index in map for future elements to get their ceil and floor key ahead of them.
* Number of odd[i] = true will be our answer.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)