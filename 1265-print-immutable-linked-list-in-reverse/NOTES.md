## Approach1: O(N) Time, O(N) Space using recursion
In this approach, I have used recursion post traversal made recursive calls till the end and then while coming back print the value of node.
​
* **Time Complexity: O(N)**
* **Space Complexity: O(N)**
​
## Approach2: O(N) Time, O(Sqrt(N)) Space
In this approach, first I have computed the number of nodes in the list. Then we have divided the list into chunks of size Math.ceil(Math.sqrt(count)). Then created array which will have first node for each chunk. They iterated over all chunks in reverse and reversed all the chunks in O(N) time using O(sqrt(N)) space.
​
* **Time Complexity: O(N)**
* **Space Complexity: O(sqrt(N))**