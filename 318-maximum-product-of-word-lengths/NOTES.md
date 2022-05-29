## Approach1: Using List of Set
In this approach, I have precomputed the length of each word in a length array and also prepared list of set where each set contains different characters a word have. At max the size of these sets will be 26 since word only containse lower case characters. Once done with precomputation, now comparing all the pair of strings and checking if there sets have anything in common or not. If not compute the product. Return Max Product.
​
### Complexity Analysis
* **Time Complexity: O(N^2 * 26) = O(N^2)**
* **Space Complexity: O(N)**
​
## Approach2: Using Bitmask and Map
* In this approach, Similar to above approach doing precomputations to store the length of words in a map. I also computing bitmask of each word since each word can have at max 26 chars so setting each bit to 1 if a particular char is present in a word.
* To set a bit in bitmask: bitmask = bitmask | (1<<(word.charAt(i)-'a'))
* Once computing bitmask we will store bitmask vs largest length of a particular bitmask it will remove words which have same charset but with different frequencies. Storing largest length since we need max product. This will reduce are comparisons.
* Then using nested loop iterate over map.keySet and if word1&word2 is 0 then compute product and return max product.
​
### Complexity Analysis
* **Time complexity : O(N^2+L) where N is a number of words and L is a total length of all words together.**
* **Space complexity : O(N) to keep a hashmap of N elements**