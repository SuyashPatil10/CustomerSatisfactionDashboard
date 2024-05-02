package com.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean checkPhoneNumber(String phoneNumber)
	{
		String regexPattern = "^\\d{10}$";

        Pattern pattern = Pattern.compile(regexPattern);

        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            return true;
        } 
        else 
        {
        	return false;
        }
	}
	
	public boolean checkEmailPattern(String pattern)
	{
		Pattern p = Pattern.compile("[a-zA-Z0-9_.]+@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher m = p.matcher(pattern);
		
		if(m.find() && m.group().equals(pattern))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkPasswordPattern(String pattern)
	{
		Pattern p = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}$");
		Matcher m = p.matcher(pattern);
		
		if(m.find() && m.group().equals(pattern))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
