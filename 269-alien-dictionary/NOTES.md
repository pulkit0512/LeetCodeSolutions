**Approach:** This question is a variation of topological sorting. One thing to note is from a given word, like "kitten" doesn't decide char 'i' before 't'. The order of characters will depend on the relation between other words.
* Created two maps one two have all the outward edges for a given character indicating the given character will come before the characters it points to with these edges. And the other map is to store indegree count of each character.
* We will iterate over all the words and in case for a consecutive pair of words we found two chars are not equal at index i, then we create an edge from the char present in first word to the char present in second word and will update the indegree of char in second word. **This edge will only be created if these two chars are not already connected**
* **In case from the given pair second word is a proper prefix of first word in this case answer is not possible return empty string. Becuase proper prefix will come first.**
* Now we will add all the characters in the queue which have 0 indegree. And will process the char and during processing we reduce the indegree of all the characters who were in the outdegree set of given char. In case indegree of any char becomes 0 we will add it to queue and will continue with the same processing.
* Answer will be the order of chars poped out of queue.
* If answer length is not equal to number of unique characters in word list then answer is empty string, else return answer we calculated using queue.
​
**Complexity Analysis**
​
Let N be the total number of strings in the input list.
​
Let C be the total length of all the words in the input list, added together.
​
Let U be the total number of unique letters in the alien alphabet. While this is limited to 2626 in the question description, we'll still look at how it would impact the complexity if it was not limited (as this could potentially be a follow-up question).
​
**Time complexity : O(C).**
​
There were three parts to the algorithm; identifying all the relations, putting them into an adjacency list, and then converting it into a valid alphabet ordering.
​
In the worst case, the first and second parts require checking every letter of every word (if the difference between two words was always in the last letter). This is O(C).
​
For the third part, recall that a breadth-first search has a cost of O(V + E), where V is the number of vertices and E is the number of edges. Our algorithm has the same cost as BFS, as it too is visiting each edge and node once (a node is visited once all of its edges are visited, unlike the traditional BFS where it is visited once one edge is visited). Therefore, determining the cost of our algorithm requires determining how many nodes and edges there are in the graph.
​
Nodes: We know that there is one vertex for each unique letter, i.e. O(U) vertices.
​
Edges: Each edge in the graph was generated from comparing two adjacent words in the input list. There are N - 1 pairs of adjacent words, and only one edge can be generated from each pair. This might initially seem a bit surprising, so let's quickly look at an example. We'll use English words.
​
abacus
algorithm
The only conclusion we can draw is that b is before l. This is the reason abacus appears before algorithm in an English dictionary. The characters afterward are irrelevant. It is the same for the "alien" alphabets we're working with here. The only rule we can draw is the one based on the first difference between the two words.
​
Also, remember that we are only generating rules for adjacent words. We are not adding the "implied" rules to the adjacency list. For example, assume we have the following word list.
​
rgh
xcd
tny
bcd
​
We are only generating the following 3 edges.
​
r -> x