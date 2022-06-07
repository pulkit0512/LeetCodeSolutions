## Approach:
Used a pointer from the end to store from right to left. Start from end of both array i.e. m-1 and n-1 untill both are greater then 0 if nums1[i] <= nums2[j] then place nums2 at nums1[k] index and decrement the pointer of array which is placed at k. If nums1 reaches to 0 while nums2 add nums2 values at k pointer.
​
### Time Complexity: O(N)
### Space Complexity: O(1)