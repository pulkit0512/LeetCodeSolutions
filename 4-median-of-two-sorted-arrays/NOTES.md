## Approach:
* Since both arrays are sorted, we try to split both of them into half and will try to find the median. For this if length of nums1 greater then nums2 swap both arrays.
* The real mid of combined array is (n+m+1)/2.
* We iterate over the nums1, with binary search find the mid of first array.
* So left part size of nums1 will be mid of nums1 and left part size of nums2 will be realmid-mid.
* From this get the 4 boundary values of both array. End value of left parts and start value of right parts.
* if leftA<=rightB and leftB<=rightA, we found the split and median if even will be (max(leftA, leftB) + min(rightA, rightB))/2.0 and if odd median will max(leftA, leftB).
* if leftA>rightB so we need to shift leftA to left so shift right pointer to mid-1.
* else shift left pointer to mid+1.
​
### Time Complexity: O(Log(M+N)
### Space Complexity: O(1)