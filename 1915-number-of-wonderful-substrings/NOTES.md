## Approach: Using Bitmask with DP
1. Set count[0] as 1 indicating mask 0 happened once.
2. Iterate over entire word.
3. find mask value at current position
4. count substrings with all even occurences
5. count substrings with just 1 odd occurence
6. update count array to increment the number of occurence we saw the mask by 1.
​
### Time Complexity: O(N)
### Space Complexity: O(1024) = O(1)
​
```
aabb
mask = 0, res = 0
mask = 1, res = 1
mask = 0, res = 3
mask = 2, res = 5
mask = 0, res = 9
​
0 1 2 3
3 1 1 0
​
a:
mask = mask^(1<<0) = 0^1 = 1
res = res + count[mask] = 0 + 0 = 0
res = res + count[mask^1] = 0 + count[1^1] = 0 + count[0] = 0 + 1 = 1 ("a")
res = res + count[mask^2] = 1 + count[1^2] = 1 + count[3] = 1 + 0 = 1
count[mask]++ = count[1]++
​
a:
mask = mask^(1<<0) = 1^1 = 0
res = res + count[mask] = 1 + count[0] = 1 + 1 = 2 ("aa")
res = res + count[mask^1] = 2 + count[0^1] = 2 + count[1] = 2 + 1 = 3 ("a")
res = res + count[mask^2] = 2 + count[0^2] = 2 + count[2] = 3 + 0 = 3
count[mask]++ = count[0]++
​
b:
mask = mask^(1<<1) = 0^2 = 2
res = res + count[mask] = 3 + count[2] = 3 + 0 = 3
res = res + count[mask^1] = 3 + count[2^1] = 3 + count[3] = 3 + 0 = 3
res = res + count[mask^2] = 3 + count[2^2] = 3 + count[0] = 3 + 2 = 5 ("aab", "b")
count[mask]++ = count[2]++
​
b:
mask = mask^(1<<1) = 2^2 = 0
res = res + count[mask] = 5 + count[0] = 5 + 2 = 7 ("aabb", "bb")
res = res + count[mask^1] = 7 + count[0^1] = 7 + count[1] = 7 + 1 = 8 ("abb")
res = res + count[mask^2] = 7 + count[0^2] = 8 + count[2] = 8 + 1 = 9 ("b")
count[mask]++ = count[0]++
```