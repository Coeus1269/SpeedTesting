package SpeedTests;

public class TestStringEqual
{
	public static void main(String[] args) 
	{
		long startTime;
		long endTime;
		long TimeTotal = 0;
		int TestLoops_int = 200000000;
		boolean Test_b = false;
		String Stest_str = "UFO";
		
		// Test to compare sring.equals() vs StringindexOf()

		for(int intLoopA = 1; intLoopA < TestLoops_int; intLoopA++) // reduce 'intLoopA < 6' to 5 to test to 1 billion
			{
			startTime = System.currentTimeMillis();
			
			// Test_b = Stest_str.equals("800") ||Stest_str.equals("UFI") ||Stest_str.equals("UFO") ;
			Test_b = "800 UFI UFO".equals(Stest_str);
			
			endTime = System.currentTimeMillis(); // set the end time outside the loop but before we do any other actions
			
			// System.out.print( (endTime - startTime) + "ms ");
			TimeTotal += ((endTime - startTime) );
			}				
		System.out.print(" AVG: " + (TimeTotal/TestLoops_int));
	}

	private boolean StringEqualsTypical(String Source_str, String CompareValue_str)
	{
		return (Source_str.equals(CompareValue_str));
	}
	
	private boolean StringEqualsNew(String Source_str, String CompareValue_str)
	{
		return (Source_str.indexOf(CompareValue_str) > -1);
	}

}
