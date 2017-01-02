public class FunctionalArrayList extends ArrayList implements FunctionalList{
	
	private int functionalArraySize = 20;
	private ReturnObject[] returnObjectFunctionalArray = new ReturnObjectImpl[functionalArraySize];	
	
	public ReturnObject head(){
		if (get(0).hasError()){
			return new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
		}
		return get(0);		
	}
	
	public FunctionalList rest(){
		FunctionalList functionalList = new FunctionalArrayList();
		
		if (size()<2){
			return functionalList;
		}		
		
		for (int i = 1; i < functionalArraySize; i++){
			returnObjectFunctionalArray[i - 1] = get(i);
		}
		return functionalList;		
	}
	
}