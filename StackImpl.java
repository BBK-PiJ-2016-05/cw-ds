public class StackImpl extends AbstractStack{
		
	public StackImpl (List list){
		super(list);
	}
	
	public boolean isEmpty(){
		return internalList.isEmpty();
	}
	
	public int size(){
		return internalList.size();
	}
	
	public void push(Object item){
		internalList.add(0, item);
	}
	
	public ReturnObject top(){
		return internalList.get(0);
	}
	
	public ReturnObject pop(){
		return internalList.remove(0);
	}
}