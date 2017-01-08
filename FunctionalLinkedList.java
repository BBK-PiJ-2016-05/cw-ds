public class FunctionalLinkedList extends LinkedList implements FunctionalList{
	
	private ListNode functionalHead = null;
	
	public ReturnObject head(){
		if (get(0).hasError()){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		return get(0);
	}
	
	public FunctionalList rest(){
		
		//Create a new empty list with a null functionalHead
		FunctionalList functionalList = new FunctionalLinkedList();
		
		//Where the original list has 0 or 1 element it returns the new empty list
		if (size()<2){
			return functionalList;
		}
		
		//Set the new functionalHead to be the second item in the original list and call this current
		functionalHead = new ListNode(get(1));
		ListNode current = functionalHead;
		
		//start counting from the 2 - the third item in the old list and second in the new list
		int count = 2;
		
		//while my count is less than the size, there is still one more item to go
		while (count < size()){
			
			//create a new node with the nth ReturnObject and give it an index n-1
			ListNode newNode = new ListNode(get(count));
			newNode.setIndex(count-1);
			
			//link this new node to the end of the chain and make this the current object
			current.setNext(newNode);
			current = newNode;
			
			//move the count forward
			count++;
		}
		return functionalList;
	}
}