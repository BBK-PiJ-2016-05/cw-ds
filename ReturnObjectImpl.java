public class ReturnObjectImpl implements ReturnObject{
	
	private ErrorMessage error;
	private Object returnValue;

	public ReturnObjectImpl(Object returnValue){
		this.returnValue = returnValue;
		this.error = ErrorMessage.NO_ERROR;
	}

	public ReturnObjectImpl(ErrorMessage error){
		this.returnValue = null;
		this.error = error;
	}
	
	public boolean hasError(){
		switch (error) {
			case NO_ERROR:
				return false;
			default:
				return true;
		}
	}

	public ErrorMessage getError(){
		return error;
	}

	public Object getReturnValue(){
		switch (error) {
			case NO_ERROR:
				return returnValue;
			default:
				return null;
		}
	}
	
}