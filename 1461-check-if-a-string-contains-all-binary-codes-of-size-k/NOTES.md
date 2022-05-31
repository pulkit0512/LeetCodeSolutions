## Approach1 : Using Set
In this Approach, I am using a set to store all the distinct substrings of length k in set while iterating over string if at any point size of set is equal to (1<<k) then return true since all byte codes of length k are present else return false.
​
### Complexity Analysis
​
* Let N be the length of s.
* **Time complexity: O(NK)**. We need to iterate the string, and use O(K) to calculate the hash of each substring.
* **Space complexity: O(NK)**. There are at most N strings with length K in the set.
​
## Approach2 : Using Rolling Hash
In this Approach, I am calculating the hash of each substring in O(1) using bitwise operations. This is called a **Rolling Hash technique. All we need to do is to remove the most significant digit and to add a new least significant digit with bitwise operations.**
​
#### For example, say s="11010110", and k=3, and we just finish calculating the hash of the first substring: "110" (hash is 4+2=6, or 110). Now we want to know the next hash, which is the hash of "101".
#### We can start from the binary form of our hash, which is 110. First, we shift left, resulting 1100. We do not need the first digit, so it is a good idea to do 1100 & 111 = 100. The all-one 111 helps us to align the digits. Now we need to apply the lowest digit of "101", which is 1, to our hash, and by using |, we get 100 | last_digit = 100 | 1 = 101.
​
* **new_hash = ((old_hash << 1) & all_one) | last_digit_of_new_hash.**
* With rolling hash method, we only need O(1) to calculate the next hash, because bitwise operations (&, <<, |, etc.) are only cost O(1).
​
### Complexity Analysis
* Let N be the length of s.
* **Time complexity: O(N).** We need to iterate the string, and use O(1) to calculate the hash of each substring.
* **Space complexity: O(2^k).** There are 2^k elements in the list.