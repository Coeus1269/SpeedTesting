package SpeedTests;

import Utils.ConsoleOut;
import Utils.Timer;

public class StringBuildervsStringAdd
{
	// test the speed performance of the String builder vs + operator
	// results total time in ms:
	//							SB Append		String +
	//	1 Concatenation				2 ms		 3 ms
	//	4 Concatenation				4 ms		 12 ms
	
	// Moved variable declaration outside of timer loop
	//	1 Concatenation				> 1 ms		 9 ms
	//	4 Concatenation				  3 ms		74 ms
	
	private static String Temp_str = "abc";
	private static StringBuilder x = new StringBuilder("abc");

	private static void TestFunction()
	{
		// String Temp_str = "abc";
		Temp_str += "def";
//		Temp_str += "ghi";
//		Temp_str += "jkl";
//		Temp_str += "mno";
		
//		// Append 5 strings together
//		StringBuilder x = new StringBuilder("abc");
//		x.append("def");
//		x.append("ghi");
//		x.append("jkl");
//		x.append("mno");
	}
	
	
	public static void main(String[] args) 
	{
		int TestLoops_int = 1000;
		Timer timer = new Timer();  // the timer class
		long intLoopA = 1; 			// the loop count, has to be a long because we are using it to calculate a time average which is a long

		// start the timer
		timer.StartTimerPaused();
				
		// This loop is used to process the action multiple times to get a more accurate average time required to completed the task.
		
		// This is the outer loop
		for( intLoopA = 1; intLoopA < TestLoops_int; intLoopA++) 
			{
			// Any prep work is done here
			// prep work, this might be creating a random value, peforming some math, pulling data from somewhere, etc.
			
			timer.ResumeTimer();  // resume the timer before calling the function to be tested
			
			// the simplest process to test, best action to call is a function or method
			// your function or method here
			TestFunction();
			
			// pause the timer outside the loop but before we do any other actions
			// total time and average time will be captured in teh timer class
			timer.PauseTimer();

			}	
		timer.EndTimer(); // stop the timer when the loop is completed
		
		// Display the average time from all the loops processed
		ConsoleOut.ConsoleOutString(timer.AverageFormatedTime(intLoopA) + " Average Time per loop");
		
		// total elapsed time
		ConsoleOut.ConsoleOutString(timer.FormatedTime() + " Total Elapsed Time: ");
				
		// just for kicks display the total paused time
		ConsoleOut.ConsoleOutString(timer.PausedtoString());
		}
}
