## Approach: DP
1. Declare a hash table freqSum that will map elements to the amount of points that we can gain from taking each element.
2. Loop through nums once to populate points to find maxNumber, which is the largest element in nums.
3. Initialize prev2 = 0 and prev = freqSum[1]. These are the base cases.
4. Loop from 2 to maxNumber.
5. At each iteration num, update prev1 and prev2. prev1 should be updated according to the recurrence relation - max(prev1, prev2 + freqSum[num]). prev2 should be updated to what prev1 was before applying the recurrence relation. This way, when we get to the next number, one step back will become two steps back, and the current step will become the previous step.
6. Return oneBack.
​
### Complexity Analysis
Given N as the length of nums and k as the maximum element in nums,
#### Time complexity: O(N + k)
To populate freqSum, we need to iterate through nums once, which costs O(N) time. Then, we iterate from 2 to k, doing O(1) work at each iteration, so this will cost O(k) time. Our final time complexity is O(N + k).
​
#### Space complexity: O(N)
The extra space we use is the hash table points.
The size of points is equal to the number of unique elements in nums. In the worst case, where every element in nums is unique, this will take O(N) space.