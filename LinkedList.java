public class LinkedList implements List{
	
	private ListNode head = null;
	
	public boolean isEmpty(){
		if (head == null){
			return true;
		}
		return false;
	}
	
	public int size(){
		int size = 0;
		if (head == null){
			return size;
		}
		ListNode current = head;
		size++;
		while (current.getNext() != null){
			size ++;
			current = current.getNext();
		}
		return size;
	}
	
	public ReturnObject get(int index){
		
		//check for error and return error message
		if (index >= this.size()||index<0){
			return new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		
		//Return the ReturnObject from the list node
		return getNode(index).getReturnObject();
	}
	
	private ListNode getNode(int index){
		
		//Cycle through list until we find the right index
		ListNode current = head;
		while (current.getIndex() != index){
			current = current.getNext();
		}
		
		//Return the list node
		return current;
	}
	
	public ReturnObject remove(int index){
		
		//Deal with error's using the get method
		if (get(index).hasError()){
			return get(index);
		}
		
		//Return the ReturnObject from the list node
		return removeNode(index).getReturnObject();
	
	}
		
	private ListNode removeNode(int index){
		
		//Keep track of what I am going to return and where to start renumbering
		ListNode returnNode = getNode(index);
		ListNode current = returnNode.getNext();
		
		//Sort out the links
		if (index==0){
			head = current;
		}
		else{
			getNode(index-1).setNext(current);
		}
				
		//Renumber everything
		while (current!=null){
			current.setIndex(current.getIndex() - 1);
			current = current.getNext();
		}
		
		//Return the list node
		return returnNode;
		
	}
	
	public ReturnObject add(int index, Object item){
		//check for error and return error message
		if (item == null){
			return new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
		}
		if (index > this.size()||index<0){	
			return new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		
		//Set up my ReturnObject with no errors and given values
		ReturnObject returnObject = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);
		
		//Add it to the list
		addNode(index, returnObject);
		
		//Return it
		return returnObject;
	}
	
	private void addNode(int index, ReturnObject returnObject){
		
		//create my new list node		
		ListNode listNode = new ListNode(returnObject);
		
		//If the list is empty set the new node as head (nothing else to do)
		if (head==null){
			head = new ListNode(returnObject);
			return;
		}
		
		//set the index
		listNode.setIndex(index);
		
		//Set the links to the new object being added
		if (index==0){
			listNode.setNext(head);
			head = listNode;
		}
		else{
			listNode.setNext(getNode(index-1).getNext());
			getNode(index-1).setNext(listNode);
		}
		
		//Fixing all the indexing starting from the item after the one being added
		ListNode current=listNode.getNext();
		while (current!=null){
			current.setIndex(current.getIndex() + 1);
			current = current.getNext();
		}
		
		//Nothing to return
		return;
	}
	
	public ReturnObject add(Object item){
		// This is a special case of the other add method but we need the index to be the last item which is the size of the list
		return this.add(this.size(), item);
	}
}
