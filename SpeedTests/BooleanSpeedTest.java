package SpeedTests;

import java.text.NumberFormat;
import java.util.Locale;

public class BooleanSpeedTest {

	public static void main(String[] args) 
	{
		boolean BoolTest = true;	// change this value based on your test true or false
		long LongLoop = 100000;
		long TrueLoopCount = 0;
		long FalseLoopCount = 0;
		long TimeTotal = 0;
		
		long startTime;
		long endTime;
		
//		Boolean Loop tests results:
//										Avg time/billion (ms)		Notes			Time Per Loop
//			if(BoolTest) 					443						When False		0.00000443
//			if(BoolTest) 					443						When True
//
//			if(BoolTest == false)			443						When False
//			if(BoolTest == false)			442						When True
			
//			if(!BoolTest) 					438						When False		
//			if(!BoolTest) 					441						When True
		
//			(BoolTest ? Var++ : Var--)		435						When True
//			(BoolTest ? Var++ : Var--)		435						When False
			
		for(int intLoopA = 1; intLoopA < 6; intLoopA++) // reduce 'intLoopA < 6' to 5 to test to 1 billion
		{	
			// run the test from 1,000,000 to 10,000,000,000 ( 1 million to 10 billion)
			LongLoop = LongLoop * 10;
			TimeTotal = 0;
			System.out.println("");
			System.out.print(NumberFormat.getNumberInstance(Locale.US).format(LongLoop) + " - ");
			
			for(int intLoopM = 0; intLoopM < 20; intLoopM++)
				{
					// run 20 of each multiple to see a general average
					TrueLoopCount = 0;
					FalseLoopCount = 0;
					startTime = System.currentTimeMillis();
					
					// the boolean test
					for(long LoopCount = 0; LoopCount < LongLoop; LoopCount++)
						{
							if(!BoolTest) //  change test type based on your test if(!BoolTest)  if(BoolTest)	if(BoolTest == false)
								{
								TrueLoopCount++; // a very simple activity that will not significantly impact the test
												// we are only testing the loop speed difference here.
								}
							else
								FalseLoopCount++;
						
						// TrueLoopCount += (BoolTest  ? 1 : 0); // a different test style
						
						}
					endTime = System.currentTimeMillis(); // set the end time outside the loop but before we do any other actions
					System.out.print( (endTime - startTime) + "ms ");
					TimeTotal += ((endTime - startTime) );
				}
			System.out.print(" AVG: " + (TimeTotal/20));
		}
	}
}





