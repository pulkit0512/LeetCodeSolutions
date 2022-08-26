## Approach:
* Say we have our answer as a stack with rightmost asteroid top, and a new asteroid comes in. If new is moving right (new > 0), or if top is moving left (top < 0), no collision occurs.
* Otherwise, if abs(new) < abs(top), then the new asteroid will blow up; if abs(new) == abs(top) then both asteroids will blow up.
* If abs(new) > abs(top), then the top asteroid will blow up (and possibly more asteroids will, so we should continue checking.) Untill the abs(new asteroid) > abs(top) of stack all the asteroids will blow up.
​
### Time Complexity: O(N)
### Space Complexity: O(N)