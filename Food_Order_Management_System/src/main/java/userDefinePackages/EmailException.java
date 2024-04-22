package userDefinePackages;
import java.util.regex.*;
public class EmailException extends Exception {
	    public EmailException(String message)
	    {
	        super(message);
	    }
	}
	class VerifyEmailData
	{
	    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    public void setEmail(String email) throws EmailException
	    {
	        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	        Matcher matcher = pattern.matcher(email);
	        if (!matcher.matches())
	        {
	            throw new EmailException("Invalid email. Enter the correct Email address....");
	        }
	    }
}


