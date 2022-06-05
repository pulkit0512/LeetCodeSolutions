## Approach: Using BFS and visited Array
In this approach, Used a queue to store the move data i.e. current coordinate and number of steps taken to reach that coordinate. Also used a visited array according to given constraints to maintain check weather we reached a given point earlier or not. While que not empty we poll out the top element check if it's the target coordinate if yes return steps taken till this coordinate. Else check all the 8 neighbours if not visited yet add in queue with +1 steps.
​
### Complexity Analysis
Given the coordinate of the target as (x,y), the number of cells covered by the circle that is centered at point (0,0) and reaches the target point is roughly (max(∣x∣,∣y∣))^2 .
​
#### Time Complexity: O((max(∣x∣,∣y∣))^2).
* Due to the nature of BFS, before reaching the target, we will have covered all the neighborhoods that are closer to the start point. The aggregate of these neighborhoods forms a circle, and the area can be approximated by the area of a square with an edge length of max(2∣x∣,2∣y∣). The number of cells within this square would be (max(2∣x∣,2∣y∣))^2.
* **Hence, the overall time complexity of the algorithm is O((max(2∣x∣,2∣y∣))^2)=O((max(∣x∣,∣y∣))^2).**
​
#### Space Complexity: Max(O(max(|x|, |y|)), O(600x600)) = O(600x600)
At any given moment, the queue contains elements that are situated in at most two different layers (or levels). In our case, the maximum number of elements at one layer would be 4⋅max(∣x∣,∣y∣), i.e. the perimeter of the exploration square. As a result, the space complexity for the queue is O(max(∣x∣,∣y∣)).
Also visited array uses a constant space of 600x600.
​
​
## Approach2: Using DFS with memoization DP.
* In this approach, Using symmetry of board we have moved the coordinate to first quadrant since answer to (x,y), (x,-y), (-x,y), (-x,-y) are same. Also starting from the target in first quadrant to reach to the origin only directions can help moving close to it i.e. left-down and down-left so neglect all other directions.
* To use memoization DP used a map to store coordinate as string vs steps.
* At each dfs call if coordinate already present in map return from map. If coordinate is origin return 0, if x+y==2 i.e. when we are at immediate neighbour then need to 2 steps.
* Else steps = min(dfs(x-1,y-2), dfs(x-2,y-1)) +1 i.e. minimum from both the possible directions as mentioned above. Store the result in map and return the steps.
​
### Complexity Analysis
Let (x,y) be the coordinate of the target.
#### Time Complexity: O(∣x⋅y∣)
* The execution of our recursive algorithm will unfold as a binary tree where each node represents an invocation of the recursive function. And the time complexity of the algorithm is proportional to the total number of invocations, i.e. total number of nodes in the binary tree.
* The total number of nodes grows exponentially in the binary tree. However, there will be some overlap in terms of the invocations, i.e. dfs(x,y) might be invoked multiple times with the same input. Thanks to the memoization technique, we avoid redundant calculations, i.e. the return value of dfs(x,y) is stored for reuse later, which greatly improves the performance.
* In the algorithm, we restrict the exploration to the first quadrant of the board. Therefore, in the worst case, we will explore all of the cells between the origin and the target in the first quadrant. In total, there are ∣x⋅y∣ cells in a rectangle that spans from the origin to the target. As a result, the overall time complexity of the algorithm is O(∣x⋅y∣).
​
#### Space Complexity: O(∣x⋅y∣)
* First of all, due to the presence of recursion in the algorithm, it will incur additional memory consumption in the function call stack. The consumption is proportional to the level of the execution tree, i.e. max(∣x∣,∣y∣).
* Secondly, due to the application of memoization technique, we will keep all the intermediate results in the memory for reuse. As we have seen in the above time complexity analysis, the maximum number of intermediate results will be O(∣x⋅y∣).
* To sum up, the overall space complexity of the algorithm is O(∣x⋅y∣), which is dominated by the memoization part.