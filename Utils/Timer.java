package Utils;

import java.util.concurrent.TimeUnit;

public class Timer 
{
	private long startTime = 0;
	private long endTime = 1; // default values in case MillisecondsDifference() is called before start and end
	private long pauseStart = 2;
	private long pauseEnd = 2 ;
	
	public void StartTimer()
	{
		startTime  = System.currentTimeMillis();
	}
	
	public long EndTimer()
	{
		endTime  = System.currentTimeMillis();
		
		return MillisecondsDifference();
	}
	
	public void PauseTimer()
	{
		pauseStart  = System.currentTimeMillis();
	}
	
	public void ResumeTimer()
	{
		pauseEnd  = System.currentTimeMillis();
	}
	
	public long MillisecondsDifference()
	{
		long pauseDiff = pauseEnd - pauseStart;
		return (endTime - startTime)- pauseDiff;
	}
	
	public String PausedtoString()
	{
		return Long.toString(pauseEnd - pauseStart) + "ms ";
	}
	
	public String toString()
	{
		return Long.toString(MillisecondsDifference()) + "ms ";
	}
	
	public String FormatedTime()
	{
		long TimeSpan = MillisecondsDifference();
		return "Elapsed Time: " + String.format("%d min : %d sec ",
			    TimeUnit.MILLISECONDS.toMinutes(TimeSpan),
			    TimeUnit.MILLISECONDS.toSeconds(TimeSpan) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(TimeSpan) )
			    
			);
	}
}

