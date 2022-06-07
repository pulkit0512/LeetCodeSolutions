## Approach:
In this approach, used a map array of 26 to store the frequecny of each char present in s. Then made a traversal on order string and added all the common chars in the order appered in order string. Once done append remaining characters of s not present in order string in any order.
​
### Complexity Analysis
* **Time Complexity: O(order.length+s.length), the time it takes to iterate through order and s**
* **Space Complexity: O(s.length). We count at most 26 different lowercase letters, but the final answer has the same length as s.**