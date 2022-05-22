* Approach: In this question, I have calculated the frequency of all the chars in the string. And then started solving those digits first which have a unique character in them like 'z' in 0 which doesn't occurs in any other digit.
* 0= count[z]
* 2= count[w]
* 4= count[u]
* 6= count[x]
* 8= count[g]
* 7=count[s] - 6
* 5=count[f] - 4
* 1=count[o] - 0 - 2 - 4
* 9=count[i] - 5 - 6 - 8
* 3=count[h] - 8
​
* **Complexity Analysis**
​
* **Time complexity : O(N)** where N is a number of characters in the input string. O(N) time is needed to compute hashmap count "letter -> its frequency in the input string". Then we deal with a data structure out which contains 10 elements only and all operations are done in a constant time.
​
* **Space complexity : O(1).** count contains constant number of elements since input string contains only lowercase English letters, and out contains not more than 10 elements.