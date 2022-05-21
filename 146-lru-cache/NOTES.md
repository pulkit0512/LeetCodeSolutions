**To implement LRU Cache, I have implemented two approaches:**
1) Using LinkedHashMap (HashMap + Double Linked List)
2) Using HashMap & Double Linked list (In this approach I have implemented the linked hashmap functionality using the data structures which it uses in backend)
​
* **Approach1: LinkedHashMap**
* For Get: Check if key exist in cache. If not return -1. If it does remove that key value pair from cache and again insert it. So that this pair comes to top. Return value.
* For Put: If cache already contains given key remove that pair. Else If cache is full remove the last pair from cache. Now insert the new pair in cache.
​
* **Approach2: HashMap + Double Linked List**
* DLLNode{
*   int key, val;
*   DLLNode next, prev;
* }
* Implement a double linked list class which supports:
* addNode in the front O(1)
* removeNode from DLL O(1)
* moveNodeToTop O(1) -> Calling removeNode and then addNode
* removeTail O(1) -> remove last node and return key of that node
​
* Now in the hashMap<Integer, DLLNode>
* For Get: if that key is not present. return -1. Else move that node to top and return it's value. O(1)
* For Put: If that key already present in map, update it's value and move that node to top. Else create a new node put into cache as well into the DLL. If cache size is greater then capacity remove last node from the DLL return it's key. And then remove deleted key from the cache as well.
​
* **Complexity Analysis**
​
* **Time complexity : O(1) both for put and get.**
​
* **Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements.**