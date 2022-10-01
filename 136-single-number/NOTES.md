## Approach:
* Use XOR operation here, since all elements appear only twice.
* a XOR a = 0 and a XOR 0 = a
* Iterate over the input and take XOR of all the array elements. Since except one all elements appear twice, they contribute 0 to XOR.
* And the unique element when XOR with 0 we will get unique element as the final XOR.
* Return the XOR result.
​
### Time Complexity: O(N)
### Space Complexity: O(1)