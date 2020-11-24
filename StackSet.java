/**
 * COMP 410
 * See inline comment descriptions for methods we need that are
 * not described in the interface.
 *
*/
package assignment1;

public class StackSet implements StackSet_Interface {
  private Node head;  	//this will be the entry point to your linked list 
                      //( it points to the first data cell, the top for a stack )
  private final int limit;  //defines the maximum size the stackset may contain
  private int size;   //current count of elements in the stackset 
  
  public StackSet( int maxNumElts ){ //this constructor is needed for testing purposes. 
    head = null;                 //Please don't modify what you see here!
    limit = maxNumElts;          //you may add fields if you need to
    size = 0;
  }
  
  //implement all methods of the interface, and 
  //also include the getRoot method below that we made for testing purposes. 
  //Feel free to implement private helper methods!
  //you may add any fields you need to add to make it all work... 
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab 
    return head;         //your data list easily.
  }

@Override
public boolean push(double elt) {
	Node current = head;
	if(this.getRoot() != null) {
		if(current.getValue() == elt) {
			return true;
		}
		while(current.getNext() != null) {
			if(current.getNext().getValue() == elt) {
				/* make elt first item and then reconstruct head to fit 
				 * everything else */
				Node oldhead = head;
				head = current.getNext();
				current.setNext(current.getNext().getNext());
				head.setNext(oldhead);
				return true;
			}
			current=current.getNext();
		}
	}
	if(this.isFull()) {
		return false;
	}
	head = new NodeImpl(elt, head);
		return true;
}

@Override
public boolean pop() {
	if(this.size() == 0) {
		return false;
	}
	Node newhead = head;
	head = newhead.getNext();
	return true;
}

@Override
public double peek() {
	// TODO Auto-generated method stub
	if(this.size() >= 1) {
		return head.getValue();
	} else {
		return Double.NaN;
	}
}

@Override
public boolean contains(double elt) {
	Node current = head;
	if(this.getRoot() != null) {
		while(current != null) {
			if(current.getValue() == elt) {
				return true;
			}
			current=current.getNext();
		}
	}
		return false;
	
}

@Override
public int size() {
	Node current = head;
	size = 0;
	if(this.getRoot() != null) {
		while(current != null) {
			current=current.getNext();
			size++;
		}
	}
	return size;
}

@Override
public int limit() {
	return this.limit;
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return this.size() == 0;
}

@Override
public boolean isFull() {
	// TODO Auto-generated method stub
	return this.size() == this.limit();
	}
}