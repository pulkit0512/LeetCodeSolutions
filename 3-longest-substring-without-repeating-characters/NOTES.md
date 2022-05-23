* **Approach1: Using Set to keep track of characters in the substring**
* In this question I have iterated over the string and added each char visited in the set if that char is not yet visited current substring. Once we get a repeated char we update the ans with max of ans of (i-st) and we start moving second pointer untill we reach to the same char and remove other while reaching to the repeated char.
* At end check wheather ans is less then len-st then update ans.
​
* **Complexity Analysis**
​
* **Time complexity : O(2n) = O(n).** In the worst case each character will be visited twice by i and j.
​
* **Space complexity : O(min(m, n)).** We need O(k) space for the sliding window, where k is the size of the Set. The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.