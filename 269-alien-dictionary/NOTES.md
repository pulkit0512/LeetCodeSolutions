**Approach:** This question is a variation of topological sorting. One thing to note is from a given word, like "kitten" doesn't decide char 'i' before 't'. The order of characters will depend on the relation between other words.
* Created two maps one two have all the outward edges for a given character indicating the given character will come before the characters it points to with these edges. And the other map is to store indegree count of each character.
* We will iterate over all the words and in case for a consecutive pair of words we found two chars are not equal at index i, then we create an edge from the char present in first word to the char present in second word and will update the indegree of char in second word. **This edge will only be created if these two chars are not already connected**
* **In case from the given pair second word is a proper prefix of first word in this case answer is not possible return empty string. Becuase proper prefix will come first.**
* Now we will add all the characters in the queue which have 0 indegree. And will process the char and during processing we reduce the indegree of all the characters who were in the outdegree set of given char. In case indegree of any char becomes 0 we will add it to queue and will continue with the same processing.
* Answer will be the order of chars poped out of queue.
* If answer length is not equal to number of unique characters in word list then answer is empty string, else return answer we calculated using queue.

**Complexity Analysis**

**Time complexity : O(C).**
Let N be the total number of strings in the input list.

Let C be the total length of all the words in the input list, added together.

Let U be the total number of unique letters in the alien alphabet.
O(C) for 1st and 2nd part of question, O(U + min(U^2, N)) for topological sorting
O(C) + O(U + min(U^2, N)) = O(C + U + min(U^2, N))
O(C + U + min(U^2, N)) → O(C + min(U^2, N))

Now, to simplify the rest, consider two cases:
If U^2 is smaller than N, then min(U^2, N) = U^2. By definition, we've just said that U^2 is smaller than N, which is in turn smaller than C, and so U^2 is definitely less than C. This leaves us with O(C).
If U^2 is larger than N, then min(U^2, N) = N. Because C > N, we're left with O(C).
So in all cases, we know that C > min(U^2, N) This gives us a final time complexity of O(C).

**Space complexity : O(1) or O(U + min(U^2, N))**

The adjacency list uses the most auxiliary memory. This list uses O(V + E) memory, where V is the number of unique letters, and E is the number of relations.
The number of vertices is simply U; the number of unique letters.
The number of edges in the worst case is min(U^2, N), as explained in the time complexity analysis.
So in total the adjacency list takes O(U + min(U^2, N)) space.
**So for the question we're given, where U is a constant fixed at a maximum of 26, the space complexity is simply O(1). This is because U is fixed at 26, and the number of relations is fixed at 26^2, so O(min(26^2, N)) = O(26^2) = O(1).**
**But when we consider an arbitrarily large number of possible letters, we use the size of the adjacency list; O(U + min(U^2, N)).**
