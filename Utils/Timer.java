package Utils;

import java.util.concurrent.TimeUnit;

public class Timer 
{
	private long startTime 				= 0;
	private long endTime 				= 1;  // default values in case MillisecondsDifference() is called before start and end
	private long pauseStart 			= 2;
	private long pauseEnd 				= 2;
	private long totalPauseTimeElapsed 	= 0; // used when Pausing
	
	// Timer Class for capturing start and end time, with a pause option
	
	// USAGE: 
	// StartTimer 				- start the timer
	// Run the code to be tested
	// EndTimer 				- stop the timer
	// Optional, PauseTimer 	- pause the timer	
	// Optional, ResumeTimer 	- continue the timer after paused		PausedtoString - display the paused time
	// Either display the processed time or save the time in a variable for displaying averages
	
	// toString -  string output of the difference between start and end time
	// FormatedTime - formated string of the time difference
	// AverageFormatedTime - formated string of the time difference that include an option to average the time
	// to use the AverageFormatedTime to display average process time for multiple loops,
	// use the PauseTimer to make sure and capture only the code to be processed and not the prep work.
	//  for example:
	//		StartTimerPaused
	//		Loop
	//			do prep work
	//			ResumeTimer
	//			call function or method to test
	// 			PauseTimer
	//		Next Loop
	//		Call AverageFormatedTime(Loops Tested int)
	// 			the average time is displayed
	
	public void StartTimer()
		{
			startTime  = System.currentTimeMillis();
		}
	
	public long EndTimer()
		{
			endTime  = System.currentTimeMillis();
			
			return MillisecondsDifference();
		}
	
	public void StartTimerPaused()
	{
		startTime  = System.currentTimeMillis();
		pauseStart  = System.currentTimeMillis();
	}
	
	public void PauseTimer()
		{
			pauseStart  = System.currentTimeMillis();
		}
	
	public void ResumeTimer()
		{
			pauseEnd  = System.currentTimeMillis();
			totalPauseTimeElapsed = totalPauseTimeElapsed + (pauseEnd - pauseStart);
		}
	
	public long MillisecondsDifference()
		{
			return (endTime - startTime) - totalPauseTimeElapsed;
		}
	
	public String PausedtoString()
		{
			if(totalPauseTimeElapsed > 0)
				return "Time Paused: " + Long.toString( totalPauseTimeElapsed) + "ms ";
			else
				return "";
		}
	
	public String toString()
		{
			if (endTime > startTime +1)
				return Long.toString(MillisecondsDifference()) + "ms ";
			else
				return "Timer was not ran";
		}
	
	public String FormatedTime()
		{
		return AverageFormatedTime(1l);
		}
	
	public String AverageFormatedTime(Long Denominator_lng)
		{
		if (endTime > startTime +1)
			{
			long TimeSpan = MillisecondsDifference() / Denominator_lng;
			return "Elapsed Time: " + 
					String.format("%d min : %d sec : %d ms"
					, TimeUnit.MILLISECONDS.toMinutes(TimeSpan)
				    , TimeUnit.MILLISECONDS.toSeconds(TimeSpan) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(TimeSpan) )
				    , TimeUnit.MILLISECONDS.toMillis(TimeSpan)
				    );
			}
		else
			return "Timer was not ran";
		}
}

