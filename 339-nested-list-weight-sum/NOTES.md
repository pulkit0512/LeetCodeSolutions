**Approach: Simple DFS**
In this for each nested list make a recursive call by incrementing the depth from the previous call in case of list and in case of integer add that integer to the sum mutiplied by depth.
​
**Complexity Analysis**
​
Let N be the total number of nested elements in the input list. For example, the list [ [[[[1]]]], 2 ] contains 4 nested lists and 2 nested integers (1 and 2), so N=6 for that particular case.
​
**Time complexity : O(N).**
​
Recursive functions can be a bit tricky to analyze, particularly when their implementation includes a loop. A good strategy is to start by determining how many times the recursive function is called, and then how many times the loop will iterate across all calls to the recursive function.
​
The recursive function, dfs(...) is called exactly once for each nested list. As N also includes nested integers, we know that the number of recursive calls has to be less than N.
​
On each nested list, it iterates over all of the nested elements directly inside that list (in other words, not nested further). As each nested element can only be directly inside one list, we know that there must only be one loop iteration for each nested element. This is a total of N loop iterations.
​
So combined, we are performing at most 2⋅N recursive calls and loop iterations. We drop the 2 as it is a constant, leaving us with time complexity O(N).
​
**Space complexity : O(N).**
​
In terms of space, at most O(D) recursive calls are placed on the stack, where D is the maximum level of nesting in the input. For example, D=2 for the input [[1,1],2,[1,1]], and D=3 for the input [1,[4,[6]]].
​
In the worst case, D = N, (e.g. the list [[[[[[]]]]]]) so the worst-case space complexity is O(N).