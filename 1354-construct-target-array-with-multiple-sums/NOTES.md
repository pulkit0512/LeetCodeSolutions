## Approach: Priority Queue (Max Heap)
* In this approach, added all elements to max heap and calculated the total sum.
* Untill we don't have peek value of max heap not equal to 1.
* Get the max from pq. Get the rest sum which is sum - max.
* For a solution max will always be less then sum but will greater then rest since according to question for constructing the target array we put sum of all elements to a specific index.
* If above condition not matched return false.
* For a edge case if rest sum == 1 return true since this can always be achieved by decrementing the max by 1.
* The new val for polled max element will be max%rest. Add it back to pq.
* Update the sum by adding new val to rest of the sum.
* At each step we reduce sum by 1/4 factor. Since max will always be atleast half of sum and due to this rest will be atmost half of sum and hence new val will be atmost half of max which is in turn half of half of sum.
* Sum = rest + newVal = 1/2 prevSum + 1/2 max = 1/2 prevSum + 1/4 prevSum
* Sum = 3/4 prevSum
* This sum reduction of 1/4 factor can be achieved in log time.
​
### Time Complexity: O(NLogN + logK.logN)
* NLogN for priority queue.
* logK for sum reduction and logN for adding and adding/polling elements
​
### Space Complexity: O(N)