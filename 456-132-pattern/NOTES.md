## Approach1: Using Min Array and Stack
* We need to find a triplet where nums[i]<nums[k]<nums[j]
* In this approach, used a min array to calculate min upto index i. This min[i] will act at nums[i] for the required triplet. Then moving from end of array if nums[j]>min[j] then we found potential nums[i] and nums[j] then we need to find a nums[k] which satisfies the given condition. Stack will hold potential nums[k]. while stack not empty pop out all elements which are <=min[j] i.e. is our current nums[i] since we need nums[k]>nums[i]. Once found that check if potential nums[k] which is peek of stack< nums[j] if yes return true. Else push nums[j] as next potential nums[k].
* **Note: Stack will always have elements in ascending sorted order. Since we always pop out smaller element then the current min and then push nums[j] which is already greater then min[j]**
* If not found after the complete iteration return false.
​
### Complexity Analysis
* **Time complexity : O(n).** We travesre over the nums array of size n once to fill the minmin array. After this, we traverse over numsnums to find the nums[k]. During this process, we also push and pop the elements on the stack. But, we can note that atmost n elements can be pushed and popped off the stack in total. Thus, the second traversal requires only O(n) time.
* **Space complexity : O(n).** The stack can grow upto a maximum depth of n. Furhter, min array of size n is used.
​
​
## Approach2: Using nums array as stack
* We need to find a triplet where nums[i]<nums[k]<nums[j]
* In this approach, used a min array to calculate min upto index i. This min[i] will act at nums[i] for the required triplet. Then moving from end of array if nums[j]>min[j] then we found potential nums[i] and nums[j] then we need to find a nums[k] which satisfies the given condition. Here I am using a pointer k which will act as stack if k<n && nums[k]<=min[j] then k++ this is similar to pop operation of stack. If k<n && nums[k]<nums[j] return true. Similar to checking if we found k satisfying given condition. Else nums[--k] = nums[j] similar to pushing nums[j] to stack.
​
### Complexity Analysis
* **Time complexity : O(n).** We travesre over the nums array of size n once to fill the minmin array. After this, we traverse over numsnums to find the nums[k]. During this process, atmost n elements can be put in and out off the nums array in total. Thus, the second traversal requires only O(n) time.
* **Space complexity : O(n).** min array of size n is used.