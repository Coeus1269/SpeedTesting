package SpeedTests;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalTest 
{
	private static BigDecimal BDtest = new BigDecimal(1.235067890);

	public static void main(String[] args) 
	{
		System.out.println(BDtest);
		//BDtest.round(new MathContext(4));
		BDtest = BDtest.add(new BigDecimal(30));
		System.out.println(BDtest);
		
		BDtest = BDtest.add(new BigDecimal(45));
		System.out.println(BDtest);
		System.out.println(BDtest.round(new MathContext(4)));
		System.out.println(BDtest.setScale(4, BigDecimal.ROUND_HALF_UP));
		
		System.out.println(getBDtestMoney());
		
		BDtest = BDtest.add(new BigDecimal(2533345));
		DecimalFormat df = new DecimalFormat("###,###.##");
		System.out.println(df.format(BDtest));
		
		df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ITALY));
		System.out.println(df.format(BDtest));

	}

	public static String getBDtestMoney()
	{
		return NumberFormat.getCurrencyInstance().format(BDtest);
	}

}

