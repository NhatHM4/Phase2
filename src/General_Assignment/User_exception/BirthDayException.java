package General_Assignment.User_exception;

public class BirthDayException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6179876502496088825L;
	public BirthDayException() {
		super("Ngay sinh khong hop le");
	}
}
