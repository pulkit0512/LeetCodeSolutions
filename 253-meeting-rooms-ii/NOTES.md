## Approach: Sorting + Min Heap
* Sort Arrays on start time.
* Create a min heap on end time.
* If current interval start time >= pq.peek() i.e. start time of next meeting greater then end time of previous meeting.
* we can use previous room for current meeting as well. So poll that meeting end time out.
* Push current meeting's end time to priority queue.
* Size of pq in the end will be the number of seperate rooms needed for all meetings.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)