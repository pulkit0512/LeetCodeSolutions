## Approach:
* We initialize a hashtable/dictionary to keep the messages along with the timestamp.
* At the arrival of a new message, the message is eligible to be printed with either of the two conditions as follows:
* case 1). we have never seen the message before.
* case 2). we have seen the message before, and it was printed more than 10 seconds ago.
* In both of the above cases, we would then update the entry that is associated with the message in the hashtable, with the latest timestamp.
* Else we will return false.
​
### Time Complexity: O(1)
### Space Complexity: O(M), Number of distinct incoming messages