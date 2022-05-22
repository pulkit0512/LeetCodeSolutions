* **Approach1: O(N) Space, O(N) Time using set**
* In this approach, I am storing node p and all it's parents in the set. Once done with p, I move to q node and will see if node q or any it's parent exist in the parent set of p. If found return the first node found it will be the LCA.
​
* **Approach2: O(1) Space, O(N) Time using two nodes pointing to p and q.**
* In this approach untill, the two pointers point to the same node we will move to the parent of each pointer and if parent of any pointer is null we point it to the opposite node i.e. if in starting 'a' node points to 'p' so whenever we reach a point where a.parent is null point 'a' node to 'q' and vice versa.
* Once both node 'a' and 'b' points to same node that is the LCA.