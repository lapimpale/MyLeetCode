// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> myItr;
    Integer nextElement;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        myItr = iterator;
        if(myItr.hasNext()){
            nextElement = myItr.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer currentNext = nextElement;
        if(myItr.hasNext()){
            nextElement = myItr.next();
        }
        else{
            nextElement = null;
        }
        return currentNext;
	}
	
	@Override
	public boolean hasNext() {
	    if(nextElement!=null){
            return true;
        }
        else{
            return false;
        }
	}
}