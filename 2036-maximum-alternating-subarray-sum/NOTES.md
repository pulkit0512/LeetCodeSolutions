## Approach: DP
1. Either we can add nums[i] to prevMinus which we got by substracting nums[i] from prevPlus.
2. So either we add current nums[i] to prevMinus or nums[i] is the max sum.
3. In case of subtracting, subtract from prevPlust which we got by adding nums[i-1] to prevMinus.
4. In case of subtractiong currMinus is prevPlus - nums[i].
5. ans is max of currPlus, currMinus.
6. Update both prevPlus and prevMinus with curr values.
​
### Time Complexity: O(N)
### Space Complexity: O(1)