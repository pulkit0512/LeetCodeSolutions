...
sum(left+1, ... right-1) = prefix[right] - prefix[left + 1]
the subarrays that start with left+2:
sum(left+2, ... i) = prefix[i + 1] - prefix[left + 2]
sum(left+2, ... i+1) = prefix[i + 2] - prefix[left + 2]
...
sum(left+2, ... right-1) = prefix[right] - prefix[left + 2]
...
​
the subarrays that start with i:
sum(i, ... i) = prefix[i + 1] - prefix[i]
sum(i, ... i+1) = prefix[i + 2] - prefix[i]
...
sum(i, ... right-1) = prefix[right] - prefix[i]
Then we combine all above terms, we have:
​
positive parts:
(prefix[i + 1] + prefix[i + 2] + ... + prefix[right]) * (i - left)
negative parts:
(prefix[left + 1] + prefix[left + 2] + ... + prefix[i]) * (right - i)
The range sum of prefix can be optimized by pre-compute prefix-sum of prefix.
```
​
### Time Complexity: O(N), 3 passes of length N
### Space Complexity: O(N), two prefix arrays, two boundary arrays and two stacks.