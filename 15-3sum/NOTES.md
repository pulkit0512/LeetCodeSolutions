* **Approach:** In this question, I have sorted the array so that we can get triplets in N^2. Since we have sorted array we can get first element via first loop and then using two pointers at i+1 and n-1 we can find the other two numbers such that sum of these three becomes 0.
* Since we don't have to store the duplicate triplets so for outer loop if current element is not equal to previous element then only proceed to second loop.
* In second loop if sum is zero update both pointers if sum is greater decrement end pointer else increment start pointer.
* While start pointer is less then end pointer and start pointer val equal to previous val increment start pointer to avoid duplicates.
* Similarly for end pointer while it is greater then start pointer and end pointer val is equal to previous val decrement end pointer to avoid duplicates.
* Above two operations were only done if start and end pointer are changed via sum check.
​
* **Complexity Analysis**
​
* **Time Complexity: O(n^2).**
* Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2). This is asymptotically equivalent to O(n^2).
​
* **Space Complexity: from O(logn) to O(n),** depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.