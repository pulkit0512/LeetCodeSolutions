## Approach1: Using sort and extra space
In this approach, sorted the input array and then using two pointers started storing the result in new array taking one element from start and next from end pointer. Then update both the pointers.
​
### Time Complexity: O(NLogN), due to sort
### Space Complexity: O(N) extra result array.
​
## Approach2: In place rearrangement
In this approach, used a dir variable if it's value is 0 it indicates next element should be greater then current element and if it's value is 1 this indicates next value should be smaller then current value. Else Swap both the values.
​
### Time Complexity: O(N)
### Space Complexity: O(1)