public class ArrayList implements List{
	
	private int arraySize = 20;
	private ReturnObject[] returnObjectArray = new ReturnObjectImpl[arraySize];
	
		
	public boolean isEmpty(){
		for (int i=0; i<arraySize; i++){
			if (returnObjectArray[i] != null){
				return false;
			}
		}
		return true;
	}
	
	public int size(){
		int count = 0;
		for (int i=0; i<arraySize; i++){
			if (returnObjectArray[i] != null){
				count++;
			}
		}
		return count;
	}
	
	public ReturnObject get(int index){
		if (index<0 || index >= arraySize){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return returnObjectArray[index];
	}

	public ReturnObject remove(int index){
		if (index<0 || index >= arraySize){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		
		//Store return object
		ReturnObject returnObject = returnObjectArray[index];
		
		//remove the object from the array by shifting everything back starting with the object after the one we want to remove
		for (int i=index + 1; i<arraySize; i++){
			returnObjectArray[i-1] = returnObjectArray[i];
		}
		
		//Return the stored return object
		return returnObject;
	}

	public ReturnObject add(int index, Object item){
		if (index<0 || index > size() || index == arraySize){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		
		if (item == null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		
		//Create the return object
		ReturnObject returnObject = new ReturnObjectImpl(item);
		
		//Move everything forward one place
		for (int i=arraySize-2; i>=index; i--){
			returnObjectArray[i+1] = returnObjectArray[i];
		}
		
		//Add the new return object to the array and return it
		returnObjectArray[index] = returnObject;
		return returnObject;
	}

	public ReturnObject add(Object item){
		return add(size(), item);
	}
}