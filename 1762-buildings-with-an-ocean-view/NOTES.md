* **Approach:** In this question, I have iterated from right to left and starting max as 0. If current height is greater then max till now we will add this index to ans array list and will update the max with current index height. Once done with the iteration are answer indexes in reverse order. Create the answer array and store indexes in reverse from so that we can have required.
​
* **Complexity Analysis**
​
* Here N is the size of the given array.
* **Time complexity: O(N).**
​
* We iterate over the given array once, and for each building height, we perform a constant number of operations.
* In Java, copying the elements from the array list to an integer array in reverse order also takes O(N).
​
* **Space complexity: O(N).**
​
* No auxiliary space was used other than for the output array.
* Although, in Java, in order to maintain a dynamic size array (since we don't know the size of the output array at the beginning), we created an extra Array List that supports fast O(1) push operation. Array List can contain at most N elements, hence for the Java solution, the space complexity is O(N).