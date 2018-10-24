package Utils;

public class ConsoleOut
{

	public static void main(String[] args)
	{
		ConsoleOutString("Testing...");
		ConsoleOutFormattedLong("Testing a Long ", 10000l);
	}

	public static void ConsoleOutString(String String_str)
		{
		System.out.println(String_str);
		}

	public static void ConsoleOutFormattedLong(String Message_str, Long Number_lng)
		{
		System.out.format(Message_str + " %,8d%n", Number_lng);
		}	
}
