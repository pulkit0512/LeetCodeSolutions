## Approach:
* Maintain two products, minSoFar and maxSoFar. We need minSoFar because in case of negative numbers and our product become negative then the other negative when multiplied with this will result in positive product.
* Also we need to handle a special case when we have 0 in array and final max product is less then 0 then return 0.
* For each number we try to find what will be the max product including this number in max product and min product or we can this number alone.
* Update answer by comparing with max product so far.
​
### Time Complexity: O(N)
### Space Complexity: O(1)