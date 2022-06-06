## Approach:
In this approach, Used a stack of processData object having processId, curTime and notProcessTime. If process is starting push the data to the stack. Else pop out the start of process calculate function time for this process subtracting not process time. Then if stack not empty update the peek process "notProcessTime" by adding process time.
​
### Time Complexity: O(NxM), N is number of logs and M is max length of log
### Space Complexity: O(N). For Stack.