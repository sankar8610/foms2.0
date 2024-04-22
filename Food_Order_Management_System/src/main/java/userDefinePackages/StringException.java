package userDefinePackages;

import java.util.regex.*;

class  VerifyStringData extends Exception
{
    public VerifyStringData(String message)
    {
        super(message);
    }
}

public class StringException
{
	String name;
	public StringException(String nam)
	{
		name=nam;
	}

    static String NAME_DISTRICT_PATTERN = "^[a-zA-Z]+\\s[a-zA-Z]+$";
    public  void setName() throws VerifyStringData
    {
        Pattern pattern = Pattern.compile(NAME_DISTRICT_PATTERN);
        if(name == null || name.trim().isEmpty() || !pattern.matcher(name).matches())
        {
            throw new VerifyStringData("Invalid name. Enter a valid name.");
        }
    }
}

