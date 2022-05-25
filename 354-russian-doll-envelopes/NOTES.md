* **LIS Variation**
* **Approach1: O(N^2) approach (TLE)**
* In this approach, sort the array on width and then we used LIS approach of N^2 for each index i, we check the max LIS for previous index which satisfies the given envelope conditions. In this loop if we found max which is equal to overall max till now break this loop. Then LIS of i is max + 1.
* Update and with max of ans and lis[i].
​
* **Time Complexity: O(N^2 + NLogN) = O(N^2). N = length of envelopes**
* **Space Complexity: O(N). LIS array.**
​
* **Approach2: O(NLogN) approach**
* In this approach, sort the array first on width in increasing order and then on height in decreasing order.
* Sort increasing in the first dimension - we also sort decreasing on the second dimension, so two envelopes that are equal in the first dimension can never be in the same increasing subsequence.
* Then create a height array out of sorted envelopes array. And calculate LIS in NLogN.
* For NLogN LIS, we create LIS array and at lis[0] store the height and length variable will have number of elements in the maximum LIS so far.
* Now for all heights if heights[i]>last element of LIS array then add the heights[i] to the LIS array and increment the length of LIS. Else find the index in LIS array where heights[i] can be inserted using binary search in Log N. if Arrays.binarySearch doesn't find the heights[i] in binary searched array it return -(insertionPoint)-1 where insertionPoint is index where this element can be added to keep binaySearched sorted.
* calculate insertion point from the returned index if negative and set LIS[index] value to heights[i].
* return length which has maximum length of LIS.
​
* **Time Complexity: O(NLogN+NLogN) = O(NLogN) for each height we made binary search call of LogN.**
* **Space Complexity: O(N), LIS array.**