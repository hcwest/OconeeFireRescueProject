package dbHelpers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.*;
import dbHelpers.*;

public class Validator {

	
	public static boolean isEmail(String emailStr) {
		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailRegex.matcher(emailStr);
		return matcher.find();
	}
//	
//	public static boolean isPhone(String phoneStr) {
//		Pattern phoneRegex = Pattern.compile("^(?=.{7,32}$)(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*((\\s?x\\s?|ext\\s?|extension\\s?)\\d{1,5}){0,1}$", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = phoneRegex.matcher(phoneStr);
//		return matcher.find();
//	}
//	
//	
//	public static boolean isURL(String urlStr) {
//		Pattern urlRegex = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = urlRegex.matcher(urlStr);
//		return matcher.find();
//	}

	public static void main(String[] args) {
		//import dbHelpers.ReadQuery;
	}
}
