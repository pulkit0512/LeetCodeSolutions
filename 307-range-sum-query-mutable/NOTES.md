## Approach: Segment Tree Range Sum Query
* Build a segment tree with capacity of 4N. Make left and right subcalls for building tree. Tree[idx] = Tree[2 x idx + 1] + Tree[2 x idx + 2].
* For update, update the index with given value. And recursively make left and right subcalls, to update the value of all upper levels.
* For query recursively fetch the sum of input range and find left right sum of query.
​
### Time Complexity:
#### Constructor: O(N)
#### Update: O(LogN)
#### SumRange: O(LogN)