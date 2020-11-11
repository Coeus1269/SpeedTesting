package Utils;

import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

public class Timer 
{
	// Timer Class for capturing start and end time, with a pause option and a simple formatted toString()
	
	// USAGE: 
	// 	StartTimer(); 							- start the timer
	// 	Optionally, StartTimerPaused(); 		- start the timer paused, requires ResumeTimer(); at the desired actual start point
	// 	Run your code to be tested
	// 	EndTimer(); 							- stop the timer
	//  System.Out.println(FormatedTime());		- display the total time formated to hours, minutes, seconds, milliseconds
	// 	Optionally, toString()					- returns a string difference in milliseconds between start and end time with the ms time unit
	
	// Optional, PauseTimer 					- pause the timer	
	// Optional, ResumeTimer 					- continue the timer after paused		
	// PausedtoString 							- display the total paused time formated to hours, minutes, seconds, milliseconds
	// toString 								- string output of the difference between start and end time e.g. 562554458 ms
	// FormatedTime();							- string of the time difference formated to hours, minutes, seconds, milliseconds
	// AverageFormatedTime();					- FormatedTime() that includes an option to average the time across multiple ran tasks
	// 		to use the AverageFormatedTime to display average process time for multiple loops,
	// 		use the PauseTimer to make sure and capture only the code to be processed and not the prep work.
	//  for example:
	//		StartTimerPaused()
	//		YourLoop
	//			do prep work
	//			ResumeTimer()
	//			function or method to test
	// 			PauseTimer()
	//		Next YourLoop
	//		AverageFormatedTime(yourLoopsTested_int)
	// 			-- the AVERAGE time is displayed formated to minutes, seconds, milliseconds
	
	private long startTime 				= 0;
	private long endTime 				= 0;  // default values in case MillisecondsDifference() is called before start and end
	private long pauseStart 			= 0;
	private long pauseEnd 				= 0;
	private long totalPauseTimeElapsed 	= 0; // used when Pausing
	
	public String StartTimer()
		{// start the timer and stores the start time
			startTime  = System.currentTimeMillis();
			return CurrentTime();
		}
	
	public long EndTimer()
		{// ends the timer, stores the end time and returns the Time elapsed in milliseconds
			endTime  = System.currentTimeMillis();
			
			return MillisecondsElapsed();
		}
	
	public void StartTimerPaused()
		{// start the timer, stores the start time and pause the timer
		StartTimer();
		pauseStart  = System.currentTimeMillis();
		}
	
	public void PauseTimer()
		{// pauses the timer
			pauseStart  = System.currentTimeMillis();
		}
	
	public void ResumeTimer()
		{//Resumes the timer and calculated the paused time
			pauseEnd  = System.currentTimeMillis();
			totalPauseTimeElapsed = totalPauseTimeElapsed + (pauseEnd - pauseStart);
		}
	
	public long MillisecondsElapsed()
		{// returns the difference in milliseconds between start and end time not including paused time
			return (endTime - startTime) - totalPauseTimeElapsed;
		}
	
	public String PausedtoString()
		{// returns a string describing the total time paused in milliseconds
			if(totalPauseTimeElapsed > 0)
				return FormatedTime("Time Paused: ", totalPauseTimeElapsed);
			else
				return "";
		}
	
	public String toString()
		{// TODO: should return the formated string
		// returns the string difference in milliseconds between start and end time with the ms time unit
			if (endTime > startTime +1)
				return Long.toString(MillisecondsElapsed()) + " ms";
			else
				return "Timer was not ran";
		}
	
	
	public String AverageFormatedTime(Long Denominator_lng)
		{// this can be used if the timer span encompass multiple tasks
		long TimeSpan = MillisecondsElapsed() / Denominator_lng;
		return FormatedTime("Average Elapsed Time: ", TimeSpan);
		}
	
	public String FormatedTime()
		{ return FormatedTime("Elapsed Time: ", MillisecondsElapsed()); }
	
	public static String FormatedTime(String Label_str, Long TotalTimeSpan_lng)
		{
		// returns a formated string with the minutes, seconds, milliseconds and total milliseconds paused
		// e.g. Elapsed Time: 0 min : 57 sec : 374 ms Time Paused: 540 ms
		if (TotalTimeSpan_lng > 1)
			{
			// long DebugOriginalTimeSpan_lng = TotalTimeSpan_lng;
			long Hours_lng = TimeUnit.MILLISECONDS.toHours(TotalTimeSpan_lng);
			if(Hours_lng > 0)
				TotalTimeSpan_lng = TotalTimeSpan_lng - TimeUnit.HOURS.toMillis(Hours_lng); // remove the Hours
			long Minutes_lng = TimeUnit.MILLISECONDS.toMinutes(TotalTimeSpan_lng);
			if(Minutes_lng > 0)
				TotalTimeSpan_lng = TotalTimeSpan_lng - TimeUnit.MINUTES.toMillis(Minutes_lng); // remove the minutes
			long Seconds_lng = TimeUnit.MILLISECONDS.toSeconds(TotalTimeSpan_lng);
			if(Seconds_lng > 0 )
				TotalTimeSpan_lng = TotalTimeSpan_lng - TimeUnit.SECONDS.toMillis(Seconds_lng); // remove the Seconds
			
			return Label_str + 
					String.format("%d hr : %d min : %d sec : %d ms"
							, Hours_lng
							, Minutes_lng
							, Seconds_lng
							, TimeUnit.MILLISECONDS.toMillis(TotalTimeSpan_lng)
							) 
							// + " Original: " + DebugOriginalTimeSpan_lng
					;					
			}
		else
			return "Timer was not ran";
		}
 
	public String CurrentTime() 
		{  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
		}	  
}