**Approach:** In this question, I have used a list to store the values which we have inserted till now and map to store the value with index at which that value is stored in list.
**insert:** If we try to insert and val already present return false.
Else put val and list.size() in map & add val to the list return true.
**remove:** If val which we try to remove not present return false.
Else get index of val from map store the last element value to this index. Remove last index from list in O(1) remove val from in O(1). Update the index of swapped element in map with current index.
**getRandom:** used random.nextInt() from 0 to size-1 to get a random number and return the value stored at that index from the list.
​
**Complexity Analysis**
​
**Time complexity. GetRandom is always O(1). Insert and Delete both have O(1) average time complexity, and O(N) in the worst-case scenario when the operation exceeds the capacity of currently allocated array/hashmap and invokes space reallocation.**
​
**Space complexity: O(N), to store N elements.**