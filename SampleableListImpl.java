public class SampleableListImpl extends LinkedList implements SampleableList{
	
	private ListNode SampleableListHead = null;
	
	public SampleableList sample(){
		SampleableList listToReturn = new SampleableListImpl();
		// If list is empty return my new empty list
		if (size()==0){
			return listToReturn;
		}
		//Cycle from 0 in multiple of 2 up to the last item (which is less than size) and add to new list
		for (int i = 0; i < size(); i = i+2){
			listToReturn.add(get(i).getReturnValue());
		}
		return listToReturn;
		
	}
}