package SpeedTests;

import Utils.ConsoleOut;
import Utils.Timer;

public class TemplateSpeedTesting
{
	// this template class should be ready and easy to implement your testing
	// the most basic process is to simply change the following function/method TestFunction() to include your code to be tested.
	// if you need to do prep work prior to the function call, to create a random value to be passed to your function for example,
	// then you will need to put the prep work before the timer start in the loop inside main().
	
	// To compare two different sections of code, process one, then log the results then process the second, etc.
	
	private static void TestFunction()
	{
		//Do someting
	}
	
	
	public static void main(String[] args) 
	{
		int TestLoops_int = 100;
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
