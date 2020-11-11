package Testing;

public class StopWatch 
{
	/**
	 A class to measure time elapsed in NanoSeconds, MicroSeconds, MilliSecons or just seconds.
	 this project was abandoned in favor of Timer.Java
	*/
    private long startTime;
    private long stopTime;
    private boolean timerStopped = false;

    public static final double NANOS_PER_SEC = 1000000000.0;
    public static final double MICROS_PER_SEC = 1000000.0;
    public static final double MILLIS_PER_SEC = 1000.0;

	/**
	 start the stop watch.
	*/
	public void start()
		{ timerStopped = false;
		startTime = System.nanoTime();		
		}

	/**
	 stop the stop watch.
	*/
	public void stop()
		{ stopTime = System.nanoTime();
		timerStopped = true;
		}
	
	private void toggleTimer()
		{
			if(timerStopped)
				timerStopped = false;
			else
				timerStopped = true;
		}

	/**
	elapsed time in seconds.
	@return the time recorded on the stopwatch in seconds
	*/

	public double elapsedTimeSeconds()
		{  return (elapsedtimeNano()) / NANOS_PER_SEC;		}
	
	/**
	elapsed time in nanoseconds.
	calling any of the elapsed time methods will stop the timer
	if not stopped already
	@return the time recorded on the stopwatch in nanoseconds
	*/
	public double elapsedtimeNano()
		{ if(!timerStopped)
			stop();
		return (stopTime - startTime);	
		}
	
	public double elapsedtimeMilli()
		{ return (elapsedtimeMicro()) / 1000;			}
	
	public double elapsedtimeMicro()
		{ return (elapsedtimeNano()) / 1000;			}
	
	
	
	public String toString()
	{   double ElapsedTime_dbl = elapsedtimeNano();
	
	if(ElapsedTime_dbl > 1000 )
		{  if(ElapsedTime_dbl > 1000000)
				{  if(ElapsedTime_dbl > NANOS_PER_SEC)
					{  return toStringSeconds(); 				
					}
				return toStringMilli(); 				
				}
			return toStringMicro();
		}
	else
		return toStringNano();
	}
	
	public String toStringSeconds()
		{ return  elapsedTimeSeconds() + " Seconds.";	}
	
	public String toStringMilli()
		{ return  elapsedtimeMilli() + " Milliseconds.";	}
	
	public String toStringMicro()
		{ return  elapsedtimeMicro() + " Microseconds.";	}
	
	public String toStringNano()
		{ return  elapsedtimeNano() + " Nanoseconds.";	}

}
