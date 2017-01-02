public class ListNode {
	private ReturnObject returnObject;
	private int index;
	private ListNode nextNode;
	
	public ListNode(ReturnObject returnObject){
		this.returnObject = returnObject;
		index = 0;
		nextNode = null;
	}	
	
	public ListNode getNext(){
		return nextNode;
	}
	
	public void setNext(ListNode nextNode){
		this.nextNode = nextNode;
	}
	
	public int getIndex(){
		return index;
	}
	
	public void setIndex(int index){
		this.index = index;
	}
	
	public ReturnObject getReturnObject(){
		return returnObject;
	}
	
}