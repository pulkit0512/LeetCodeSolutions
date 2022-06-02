## Approach: Using Map
1. First, we initialize a hashtable container in our data structure.
2. For the add(number) function, we build a frequency hashtable with the number as key and the frequency of the number as the value in the table.
3. For the find(value) function, we then iterate through the hashtable over the keys. For each key (number), we check if there exists a complement (value - number) in the table. If so, we could terminate the loop and return the result.
4. In a particular case, where the number and its complement are equal, we then need to check if there exists at least two copies of the number in the table.
​
### Complexity Analysis
​
* **Time Complexity:**
* **For the add(number) function: O(1)**, since it takes a constant time to update an entry in map.
* **For the find(value) function: O(N)**, where N is the total number of unique numbers. In the worst case, we would iterate through the entire table.
​
* **Space Complexity: O(N)**, where N is the total number of unique numbers that we will see during the usage of the data structure.