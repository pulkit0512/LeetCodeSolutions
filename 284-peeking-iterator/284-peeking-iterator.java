// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer peekValue = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peekValue==null){
            if(!it.hasNext()){
                throw new NoSuchElementException();
            }
            peekValue = it.next();
        }
        return peekValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peekValue!=null){
            Integer val = peekValue;
            peekValue = null;
            return val;
        }
        if(!it.hasNext()){
            throw new NoSuchElementException();
        }
        
        return it.next();
	}
	
	@Override
	public boolean hasNext() {
	    return it.hasNext() || peekValue!=null;
	}
}