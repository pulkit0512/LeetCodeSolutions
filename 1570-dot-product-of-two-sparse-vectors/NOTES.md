* **Approach1: Non-efficient Array Approach(Since we ignore the sparcity of array)**
* Simple dot product implementation
* ans += this.nums[i]*vec.nums[i];
​
* **Complexity Analysis**
* Let n be the length of the input array.
​
* **Time complexity: O(n)** for both constructing the sparse vector and calculating the dot product.
​
* **Space complexity: O(1)** for constructing the sparse vector as we simply save a reference to the input array and O(1) for calculating the dot product.
​
* **Approach2: Two pointers (Efficient since it takes sparcity into consideration)**
* For each vector create a list of pair storing the index and it's value for all non zero values. And then using two pointers to calculate the dot product. If index is equal for both pointers do multiplication and increment pointers. otherwise increment the pointer who is pointing to smaller index.
​
* **Complexity Analysis**
* Let n be the length of the input array and L and L2 be the number of non-zero elements for the two vectors.
​
* **Time complexity: O(n)** for creating the <index, value> pair for non-zero values; O(L+L2) for calculating the dot product.
​
* **Space complexity: O(L)** for creating the <index, value> pairs for non-zero values. O(1) for calculating the dot product.
​
* **Follow up: If only one vector is sparse. Then instead of doing dot product with complexity O(L+L2) we should use binary search in non-sparse vector say L2 with indexes from L1 which is sparse vector.**
* Then time complexity to calculate dot product will be then O(L1 + L1Log(L2)) this is much better in case L1 = 5 L2 = 1024 then
​
* O(L1+L2) = 1029 whereas O(L1+L1LogL2) = 5 + 5*Log(1024) = 5 + 5*10 = 55 which makes the difference.