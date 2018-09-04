package SpeedTests;

public class TestPaddingSpeed
{
	public static void main(String[] args) 
	{
		long startTime;
		long endTime;
		long TimeTotal = 0;
		int TestLoops_int = 10;
		String Temp_str;

		System.out.print("Right Pad Zeros: ");
		for(int intLoopA = 1; intLoopA < TestLoops_int; intLoopA++) 
			{
			startTime = System.currentTimeMillis();
			Temp_str = rightPadZeros("hey ".trim(), 5);
			endTime = System.currentTimeMillis(); // set the end time outside the loop but before we do any other actions

			System.out.print(Temp_str);
			
			System.out.print( " " + (endTime - startTime) + "ms ");
			TimeTotal += ((endTime - startTime) );
			}				
		System.out.println("\nAVG: " + (TimeTotal/TestLoops_int));
		
		
		System.out.print("Different right Pad Zeros: ");
		for(int intLoopA = 1; intLoopA < TestLoops_int; intLoopA++) 
			{
			startTime = System.currentTimeMillis();
			Temp_str = MyRightPadZeros("hey ".trim(), 10);
			endTime = System.currentTimeMillis(); // set the end time outside the loop but before we do any other actions
	
			System.out.print(Temp_str);
			
			System.out.print( " " + (endTime - startTime) + "ms ");
			TimeTotal += ((endTime - startTime) );
			}				
	System.out.println("\nAVG: " + (TimeTotal/TestLoops_int));
	
	System.out.print("Another right Pad Zeros: ");
	for(int intLoopA = 1; intLoopA < TestLoops_int; intLoopA++) 
		{
		startTime = System.currentTimeMillis();
		Temp_str = AnotherRightPadZeros("hey ".trim(), 10);
		endTime = System.currentTimeMillis(); // set the end time outside the loop but before we do any other actions

		System.out.print(Temp_str);
		
		System.out.print( " " + (endTime - startTime) + "ms ");
		TimeTotal += ((endTime - startTime) );
		}				
	System.out.println("\nAVG: " + (TimeTotal/TestLoops_int));

	System.out.print("Optimal right Pad Anything: ");
	for(int intLoopA = 1; intLoopA < TestLoops_int; intLoopA++) 
		{
		startTime = System.currentTimeMillis();
		Temp_str = OptimlPadAny("hey ".trim(), 10, "0", true);
		endTime = System.currentTimeMillis(); // set the end time outside the loop but before we do any other actions
	
		System.out.print(Temp_str);
		
		System.out.print( " " + (endTime - startTime) + "ms ");
		TimeTotal += ((endTime - startTime) );
		}				
	System.out.println("\nAVG: " + (TimeTotal/TestLoops_int));


	}
	
	// most optimal left or right padding function
	// this method allows for the most flexibility
    public static String OptimlPadAny( String Temp_str, int TotalLength, String Padding_str, boolean PadRight)
    {
    	String PaddedString = Temp_str;
    	
    	if (PadRight)
    		PaddedString = OptimalPadRight(PaddedString, TotalLength, Padding_str);
    	else
    		PaddedString = OptimalPadLeft(PaddedString, TotalLength, Padding_str);
    	
    	return PaddedString;
    	
    }
    
    public static String OptimalPadRight( String s, int length, String PaddChar_str )
    {    	
        for( int i = s.length(); i < length; ++i )
        {
            s = s + PaddChar_str;
        }
        return s;
    }
    
    public static String OptimalPadLeft( String s, int length, String PaddChar_str )
    {    	
        for( int i = s.length(); i < length; ++i )
        {
            s = s + PaddChar_str;
        }
        return s;
    }
    
    public static String rightPadZeros( String s, int length )
    {    	
        for( int i = s.length(); i < length; ++i )
        {
            s.concat("0");
        }
        return s;
    }
    
    public static String AnotherRightPadZeros( String s, int length )
    {    	
        for( int i = s.length(); i < length; ++i )
        {
            s = s + "0";
        }
        return s;
    }
    
    public static String MyRightPadZeros( String s, int length )
    {
    	// possible performance improvement 
    	 String Temp_str = s + "00000000000000000000"; // maximum zeros added = 20
    	 return Temp_str.substring(0,length);
    }
    
    public static String MyAnyPad( String Temp_str, int TotalLength, String Padding_str, boolean RightPad, boolean LeftPad)
    {
    	String PaddedString = Temp_str;
    	
    	if (RightPad)
    		PaddedString = MyRightPad(PaddedString, TotalLength, Padding_str);
    	
    	if (LeftPad)
    		PaddedString = MyLeftPad(PaddedString, TotalLength, Padding_str);
    	
    	return PaddedString;
    	
    }
    
    public static String MyRightPad( String Temp_str, int TotalLength, String Padding_str)
    {
    	// Padding_str should be the max length of the desired string results
    	 Temp_str += Padding_str; 
    	 return Temp_str.substring( 0, TotalLength);
    }
    
    public static String MyLeftPad( String Temp_str, int TotalLength, String Padding_str)
    {
    	// Padding_str should be the max length of the desired string results
    	 Temp_str = Padding_str + Temp_str; 
    	 return Temp_str.substring( 0, TotalLength);
    }




}
