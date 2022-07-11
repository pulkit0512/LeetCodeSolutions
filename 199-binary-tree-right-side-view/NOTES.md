## Approach:
* Use Binary tree level order traversal.
* After end of each level add null. When a null is polled out push null again to mark end of next level.
* Result list will have all last elements of a level i.e. element before the null value.
​
### Time Complexity: O(N)
### Space Complexity: O(N), since in a complete binary tree last level can have N/2 nodes.