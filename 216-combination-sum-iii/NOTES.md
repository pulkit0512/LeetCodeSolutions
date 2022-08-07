## Approach: Backtracking
* Used backtracking to get all the list of size k whose elements sum is equal to n.
* Since we can't same element twice so in recursive calls to find next element, we start last element added in the list - 1.
* When k and n becomes 0 we found one of the list and using backtracking we can find other lists.
​
### Time Complexity: O((9! x K)/(9-K)!), Since in worst case we need to explore all possible paths, so number of exlporation will be P(9,K)=9!/(9-K)! and when get a list it's O(K) operation to copy list in final result. So Overall complexity becomes = O((9! x K)/(9-K)!)
​
### Space Complexity: O(K), K size each list and K size recursion stack.