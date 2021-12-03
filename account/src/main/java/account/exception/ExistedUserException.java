package account.exception;

@SuppressWarnings("serial")
public class ExistedUserException extends Exception {
	public ExistedUserException(String message){
		super(message);
	}
}
