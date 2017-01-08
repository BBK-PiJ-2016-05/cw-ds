public class ImprovedStackImpl implements ImprovedStack{
	
	private Stack underlyingStack;
	
	public ImprovedStackImpl(List list){
		underlyingStack = new StackImpl(list);
	}
	
	public ImprovedStack reverse(){
		return new ImprovedStackImpl(reverseList(readStack()));
	}
	
	public void remove(Object object){
		List list = readStack();
		for (int i=0; i < list.size(); i++){
			if (list.get(i).getReturnValue() == object){
				list.remove(i);
			}
		}
		underlyingStack = new ImprovedStackImpl(list);
	}
	
	public boolean isEmpty(){
		return underlyingStack.isEmpty();
	}
	
	public int size(){
		return underlyingStack.size();
	}
	
	public void push(Object item){
		underlyingStack.push(item);
	}
	
	public ReturnObject top(){
		return underlyingStack.top();
	}
	
	public ReturnObject pop(){
		return underlyingStack.pop();
	}
	
	private List readStack(){
		List list = new LinkedList();
		while (!underlyingStack.isEmpty()){
			list.add(underlyingStack.pop());
		}
		for (int i=list.size()-1; i >= 0; i--){
			underlyingStack.push(list.get(i).getReturnValue());
		}
		return list;
	}
	
	private List reverseList(List list){
		List reversedList = new LinkedList();
		for (int i=list.size()-1; i >= 0; i--){
			reversedList.add(list.get(i));
		}
		return reversedList;
	}
	
}