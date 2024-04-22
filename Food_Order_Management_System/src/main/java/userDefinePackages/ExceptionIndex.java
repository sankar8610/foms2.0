package userDefinePackages;

public class ExceptionIndex {
 
	

	public void validateId(String id) throws InvalidIdException {
	 if (!id.matches("\\d+")) {
	 throw new InvalidIdException("Invalid ID: ID must contain only digits.");
	 }
	 }
	 public void validateName(String name) throws InvalidNameException {
	 if (!name.matches("[a-zA-Z]+")) {
	 throw new InvalidNameException("Invalid Name: Name must contain only alphabets.");
	 }
	 }
	
	 
	 public void validateEmail(String email) throws InvalidEmailException {
	 if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) 
	{
	 throw new InvalidEmailException("Invalid Email: Please enter a valid email address.");
	 }
	 
	 }
}
 class InvalidIdException extends Exception{
	 
	public InvalidIdException(String s) {

	 super(s);
	 }
	}
class InvalidNameException extends Exception {
	 public InvalidNameException(String message) {
	 super(message);
	 }
class InvalidDepartmentException extends Exception {
	 public InvalidDepartmentException(String message) {
	 super(message);
	 }
}
}
class InvalidEmailException extends Exception {
	 public InvalidEmailException(String message) {
	 super(message);
	 }
}
