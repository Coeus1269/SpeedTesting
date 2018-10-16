package SpeedTests;

import java.util.Random;

import Utils.Timer;

public class IfvsSwitch
{
	// This testing module is meant to compare a switch statement vs a series of if else
	// initially the if else appears to have an advantage because when the if that is true is encountered
	// testing ends there.
	// however, mathematically, if there are 5 if statements then the average number of tests would be approximately 3 per loop
	// the question then is, is a switch statement with 5 options faster than an average of 3 if statement tests
	
	// RESULTS: they are almost identical in time.
	// this test showed that in a loop of 100,000, both processed completely in approximately 14ms
	// therefore a switch or cases statement is better for human readability and should be used whenever possible
	
	private static boolean TestIfElse(int Test_int)
		{
		Boolean Found_bln = false;
		
			if(Test_int == 0)
				Found_bln = true;
			else if(Test_int == 1)
				Found_bln = true;
			else if(Test_int == 2)
				Found_bln = true;
			else if(Test_int == 3)
				Found_bln = true;
			else if(Test_int == 4)
				Found_bln = true;
			else if(Test_int == 5)
				Found_bln = true;
			else if(Test_int == 6)
				Found_bln = true;
			else if(Test_int == 7)
				Found_bln = true;
			else if(Test_int == 8)
				Found_bln = true;
			else if(Test_int == 9)
				Found_bln = true;
			else if(Test_int == 10)
				Found_bln = true;
			else if(Test_int == 11)
				Found_bln = true;
			else if(Test_int == 12)
				Found_bln = true;
			else if(Test_int == 13)
				Found_bln = true;
			else if(Test_int == 14)
				Found_bln = true;
			else if(Test_int == 15)
				Found_bln = true;
			else if(Test_int == 16)
				Found_bln = true;
			else if(Test_int == 17)
				Found_bln = true;
			else if(Test_int == 18)
				Found_bln = true;
			else if(Test_int == 19)
				Found_bln = true;
			
		return Found_bln;
		}
	
	
	private static boolean TestSwitch(int Test_int)
		{
		Boolean Found_bln = false;
		switch(Test_int)
			{
			case 0: Found_bln = true;
			case 1: Found_bln = true;
			case 2: Found_bln = true;
			case 3: Found_bln = true;
			case 4: Found_bln = true;
			case 5: Found_bln = true;
			case 6: Found_bln = true;
			case 7: Found_bln = true;
			case 8: Found_bln = true;
			case 9: Found_bln = true;
			case 10: Found_bln = true;
			case 11: Found_bln = true;
			case 12: Found_bln = true;
			case 13: Found_bln = true;
			case 14: Found_bln = true;
			case 15: Found_bln = true;
			case 16: Found_bln = true;
			case 17: Found_bln = true;
			case 18: Found_bln = true;
			case 19: Found_bln = true;
			}
			
		return Found_bln;
		}
	
	private static void TestFunction(int Test_int)
		{
			// TestIfElse(Test_int);
			 TestSwitch(Test_int);
		}
	
		
	public static void main(String[] args) 
	{
		int TestLoops_int = 100000;
		Timer timer = new Timer();  // the timer class
		long intLoopA = 1; 			// the loop count, has to be a long because we are using it to calculate a time average which is a long
		Random rand = new Random();
		int Random_int;
		int TotalRandoms_int = 0;
		
		// start the timer
		timer.StartTimerPaused();
		
		// This is the outer loop
		for( intLoopA = 1; intLoopA < TestLoops_int; intLoopA++) 
			{
			// we will create a random number between 1 and 10 then pass it into the test function and log the time
			Random_int = rand.nextInt(20);
			TotalRandoms_int += Random_int;
			
			// First test will be testing the if else process

			timer.ResumeTimer();  // resume the timer before calling the function to be tested
			
			// the simplest process to test, best action to call is a function or method
			// your function or method here
			TestFunction(Random_int);
			
			// pause the timer outside the loop but before we do any other actions
			// total time and average time will be captured in teh timer class
			timer.PauseTimer();

			}	
		timer.EndTimer(); // stop the timer
		
		
		// Display the average time from all the loops processed
		ConsoleOut(timer.AverageFormatedTime(intLoopA) + " Average per loop");
		
		// total elapsed time
		ConsoleOut(timer.FormatedTime() + " Total");
		
		// just for kicks display the total paused time
		ConsoleOut(timer.PausedtoString());
		
		ConsoleOut("Average random number " + TotalRandoms_int / intLoopA);
		ConsoleOut("Loops Processed: " + intLoopA);
	}
	
	public static void ConsoleOut(String String_str)
		{
			System.out.println(String_str);
		}

}
