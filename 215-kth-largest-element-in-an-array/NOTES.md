## Approach1: Using Arrays.sort()
Directly sort the array and return nums.length-k value.
​
#### Complexity Analysis
**Time Complexity: O(NLogN)**
**Space Complexity: O(1)**
​
## Approach2: Using Priority Queue(heap)
Store the first k elements in priority queue which is min heap. Once done with K insertions, iterate over rest of the array and if nums[i] is greater then peek of queue, poll the peek out and insert the nums[i] to priority Queue.
At the end peek of queue will be kth largest element.
​
#### Complexity Analysis
**Time complexity : O(Nlogk).**
**Space complexity : O(k) to store the heap elements.**
​
## Approach3: Using Quickselect
In this approach to find the kth largest element it will be present at (n-k)th index i.e. (n-k)th smallest element.
Given a left and right of the array, if left and right are same return nums[left]. Else randomly pick a pivot index between left right. Call a partition method which we take the array, left, right and randomly choosed pivot index. What this method does is it places the pivot element to it's correct index which means all elements to the left of pivot element will be smaller and all to the right will be greater and return this pivot element index. If pivot element index is equal to kSmall index return this value as answer. Else if it's greater then kSmall index reduce the right pointer to pivot index - 1 else increase left pointer to pivot index + 1 and recursively make a call to the quick select function.
​
Partion method algo:
Store the value of pivot in a variable and have a index which will store the smaller values the pivot.
swap pivot index with right.
from left to right, if nums[i]<val then swap i and idx then increment idx.
once done swap idx with right since we have stored pivot there in the beginning return idx.
​
#### Complexity Analysis
**Time complexity : O(N) the average case, O(N^2) in the worst case.**
**Space complexity : O(1).**