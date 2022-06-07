## Approach:
In this approach, I have used queue of pair to store the timestamp and the count of hits on that timestamp. And I am using a counter variable which will keep track of all the hits in last 5 minutes. For each hit increment the counter by 1.
For getHits while current timestamp - 300 is greater then queue peek time poll it out and subtract the count of hits on the polled out timestamp. This will help us in case when we have multiple repeations say "K" then instead of removing them one by one remove complete in O(1). Return the counter after removing all stale hits.
​
### Complexity Analysis
​
#### Time Complexity:
* **hit - O(1).**
* **getHits - If there are a total of n pairs present in the deque, worst case time complexity can be O(n). However, by clubbing all the timestamps with same value together, for the ith timestamp with k repetitions, the time complexity is O(1) as here, instead of removing all those k repetitions, we only remove a single entry from the deque.**
​
#### Space complexity:
* If there are a total of N elements that we encountered throughout, the space complexity is O(N). However, in the case of repetitions, the space required for storing those k values O(1).