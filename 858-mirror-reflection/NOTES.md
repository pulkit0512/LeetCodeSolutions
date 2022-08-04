## Approach:
* Need to find two variables m & n such m x p == n x q
* m & n can't be both even since we can divide them by 2 and still satisfy this eqaution.
* So m=q and n=p, we reduce them both by 2 untill atleast one of them becomes odd.
* if m==odd and n==odd return 1
* if m == odd and n==even return 2
* if m == even and n== odd return 0
​
### Time Complexity: O(Log(min(p, q))
### Space Complexity: O(1)