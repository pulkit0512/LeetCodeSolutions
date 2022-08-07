## Approach: DP
* According to given rules, 'a' can be only followed by 'e'. So if we start from right to left, number of ways we can have 'a' in front for current state is equal to number of ways we can have 'e' in front for previous state.
* Similarly for 'e' in current state = 'a' + 'i' in previous state
* for 'i' in current state = 'a' + 'e' + 'o' + 'u' in previous state
* for 'o' in current state  = 'i' + 'u' in previous state
* for 'u' in current state = 'a' in previous state
* So answer is sum of all these ways after n length.
​
### Time Complexity: O(N)
### Space Complexity: O(1)