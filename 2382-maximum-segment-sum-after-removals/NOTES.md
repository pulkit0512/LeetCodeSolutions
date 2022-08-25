## Approach
* Union Find
* In the end, we remove all elements from the array (nums.length == removeQueries.length).
* So, we can start from no segments, add elements in the reverse (of the removal) order, and create/merge segments.
* As we add an element, it can either:
* create a new segment (e.g. , [7], )
* join an existing segment on the left (e.g. 5, 6, [7], )
* join an existing segment on the right (e.g. , [7], 8, 9)
* merge existing segments on the left and right into one (e.g. 5, 6, [7], 8, 9)
* root[i] will be negative of nums[i], we check if an element on the left/right has been inserted, then do a merge if it has.
* A non-negative value at any index of the root array points to the "parent". A negative value is the negated sum of all elements in the set.
​
### Time Complexity: O(N x @(N)), @(N) is inverse Ackerman function which takes almost constant time.
### Space Complexity: O(N)