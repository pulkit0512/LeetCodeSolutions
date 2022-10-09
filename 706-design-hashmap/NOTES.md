## Approach:
* HashMap is built on Array of linkedLists and each linkedList is called a bucket.
* On an average each bucket will have threshold number of elements in it. This threshold is defined by the user and is called a LoadFactor and this almost a constant.
* As soon as the average size passes this load factor we ReHash the entire map. So by doing one heavy operation rarely to maintain the average we acheive constant time for all the required functions in the map.
* For deciding to which bucket each entry will go in map, I am using hashCode provided by java for all the objects % by total buckets.
​
### put(k, v)
* First for the key find the bucket using hashCode and modulo operation.
* Once done, then check in the bucket if this key already exist or not.
* If exists, update the value of key. Else add a new node to this bucket and increment the size of nodes in map.
* As soon as average size of buckets crosses load factor rehash the enitre map.
​
### rehash()
* In this, first keep reference of the oldBuckets and then initialize new array of linkedlists of size double then the oldBuckets length.
* And reset the size to 0.
* Then call put method on the all nodes present in the old buckets.
​
### get(k)
* First find the bucket in which this Key can possibly reside using hashCode and modulo.
* Then check if this node is present in that bucket or not.
* If present return the value of node. Else return null.
​
### containsKey(k)
* First find the bucket in which this Key can possibly reside using hashCode and modulo.
* Then check if this node is present in that bucket or not.
​
### remove(k)
* First find the bucket in which this Key can possibly reside using hashCode and modulo.
* Then check if this node is present in that bucket or not.
* If exist, remove the node from the bucket and decrement the size of map.
* Else return null.
​
### size()
* return the value stored in size variable.