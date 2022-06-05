## Approach:
In this approach, used idx pointer to point to index which needs to be updated. Traversed the char array if equal prev char increment it's count else update char array at idx pointer with prevChar and if count greater then 1 update char array at idx pointer with count chars. At end update the last char with idx pointer and it's count as well.
​
### Time Complexity: O(N)
### Space Complexity: O(1), In place arrangement.