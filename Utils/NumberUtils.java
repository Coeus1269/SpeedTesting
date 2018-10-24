package Utils;

import java.text.DecimalFormat;
import java.util.Locale;

public class NumberUtils
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static String FormattedLongToString( Long Number_lng)
		{
		// TODO: get locale from system
		return String.format(Locale.US," %,8d", Number_lng);
		}
	
	public static String FormattedLongToString( String Format_str, Long Number_lng)
		{
		// TODO: get locale from system
		return String.format(Locale.US, Format_str, Number_lng);
		}
	
	public static String FormattedLongToString(Locale Locale_l, String Format_str, Long Number_lng)
		{
		return String.format(Locale_l, Format_str, Number_lng);
		}
	
	public static String FormattedDecimalToString(Double Decimal_dbl, String pattern_str)
		{
		if (pattern_str.length() < 3)
			pattern_str = "###,##0.00";				// Default standard format
		
		if (pattern_str.toUpperCase() == "MONEY")
			pattern_str = "$###,##0.00";
		
		DecimalFormat myDecimalFormater = new DecimalFormat(pattern_str);
	      return myDecimalFormater.format(Decimal_dbl);
		}
	
	
}
