* **Approach1: Using StringBuilder as a type of stack**
* In this, I have used two counters one to count chars and other to count '.' between two '/'. I am appending the chars to ans string if it is not a '/'. And in case of char I am incrementing char counter and setting dot counter to 0 and in case of dot if char counter is 0 which means no char between two '/' then increment dot counter. If we get a '/' and ans is empty I am appending it. If last char added to answer is also '/' then ignoring this '/' and if we have 1 dot between two '/' then removing that dot. Or if we have two dots between two '/' then I am moving to the parent directory after deleting the two dots and in case current directory exist removing that as well.
* In end if we have unsettled 1 or 2 dots then again doing the same operation to settle them and if in the end last char of ans is '/' and length greater then 1 we removing that '/' because ans can't end with a '/'.
​
* **Time Complexity: O(2N) = O(N)** since max we traverse each character twice.
​
* **Space Complexity: O(1)** no extra space only answer string.
​
* **Approach2: Using Stack**
* In this, first I have splitted the path on '/' and then traversed the splitted array in case current string is empty or a single dot ignoring that. In case current string is ".." then if stack not empty poping that string out. Else adding current string to stack. Once done with this traversal, traverse the stack and create the canonical path by appending '/' and then string from stack.
* if ans empty return "/" else return ans string.
​
* **Complexity Analysis**
​
* **Time Complexity: O(N)** if there are N characters in the original path. First, we spend O(N) trying to split the input path into components and then we process each component one by one which is again an O(N) operation. We can get rid of the splitting part and just string together the characters and form directory names etc. However, that would be too complicated and not worth depicting in the implementation. The main idea of this algorithm is to use a stack. How you decide to process the input string is a personal choice.
* **Space Complexity: O(N).** Actually, it's 2N because we have the array that contains the split components and then we have the stack.