## Approach1: Using Set Intersection
* Created a LinkedHashSet with all elements from the first row.
* Then for all the subsequent rows, checked if current row element is present in previous row set as well. Then add this value to current row set.
* Now point the previous row set to this and move to the next.
* In the end if set is empty return -1 else return 1st value of set since input is in sorted order row-wise and we are using linked hashset which will maintain insertion order. So first element will be the smallest.
​
### Time Complexity: O(MN)
### Space Complexity: O(N)
​
## Approach2: Using Row pointers
* For all rows, create a row pointer array which will have info about current column each row points to.
* Now for all the columns pointed by each row, find the minimum value from matrix.
* For all the elements having value equal to minimum value will move one step ahead in columns.
* If all the values pointed by the row arrays is equal to min value then this min value is the answer.
* Repeat this step until we get the answer or we reach end of any row.
* If we reach end of any row then return -1.
​
### Time Complexity: O(MN)
### Space Complexity: O(N)