## Approach: Stack and Prefix Sum
```
Most tricky part before involving math:
For each strength[i], we could find a non-empty index range (left, right) where strength[i] is the min value. So for all subarrays in this range including strength[i], the total strength is strength[i] * the sum of those subarray sums.

left is the first index on the left side i where strength[left] < strength[i]
right is the first index on the right side of i where strength[right] <= strength[i]

The reason we use < on left but <= on right is to avoid duplicates.
Here is an example array: 1 **2 3 4 2** 3 4 2 1
For the highlighted subarray 2 3 4 2, we want to calculate the strength using the 2nd 2 but not the first 2.

How do we get the "sum of all subarrays including strength[i] in range (left, right)"?
Let's list the indices:
...left-1, left, left + 1, left + 2, ... i-1, i, i+1, ... right-1, right, right+1...

Let prefix[i] be the prefix sum of first i elements in strength.

The sum of subarrays including i are:

the subarrays that start with left+1:
sum(left+1, ... i) = prefix[i + 1] - prefix[left + 1]
sum(left+1, ... i+1) = prefix[i + 2] - prefix[left + 1]
...
sum(left+1, ... right-1) = prefix[right] - prefix[left + 1]
the subarrays that start with left+2:
sum(left+2, ... i) = prefix[i + 1] - prefix[left + 2]
sum(left+2, ... i+1) = prefix[i + 2] - prefix[left + 2]
...
sum(left+2, ... right-1) = prefix[right] - prefix[left + 2]
...

the subarrays that start with i:
sum(i, ... i) = prefix[i + 1] - prefix[i]
sum(i, ... i+1) = prefix[i + 2] - prefix[i]
...
sum(i, ... right-1) = prefix[right] - prefix[i]
Then we combine all above terms, we have:

positive parts:
(prefix[i + 1] + prefix[i + 2] + ... + prefix[right]) * (i - left)
negative parts:
(prefix[left + 1] + prefix[left + 2] + ... + prefix[i]) * (right - i)
The range sum of prefix can be optimized by pre-compute prefix-sum of prefix.
```

### Time Complexity: O(N), 3 passes of length N
### Space Complexity: O(N), two prefix arrays, two boundary arrays and two stacks.
