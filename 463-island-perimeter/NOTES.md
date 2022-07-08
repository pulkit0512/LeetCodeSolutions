## Approach
* Go through every cell on the grid and whenever you are at cell 1 (land cell), look for surrounding (UP, RIGHT, DOWN, LEFT) cells. A land cell without any surrounding land cell will have a perimeter of 4. Subtract 1 for each surrounding land cell.
* When you are at cell 0 (water cell), you don't need to do anything. Just proceed to another cell.
​
### Time Complexity: O(MN)
### Space Complexity: O(1)