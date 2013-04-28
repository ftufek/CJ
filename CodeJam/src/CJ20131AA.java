import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Scanner;

import javafx.util.converter.BigIntegerStringConverter;


public class CJ20131AA {
	public static String solve(BigInteger r, BigInteger t){
		BigInteger low = BigInteger.ZERO;
		BigInteger high = BigInteger.valueOf(10).pow(20);
		BigInteger one = BigInteger.ONE;
		BigInteger two = BigInteger.valueOf(2);
		
		while(high.compareTo(low.add(one))>0){
			BigInteger mid = low.add(high).divide(two);
			if(mid.multiply(two).multiply(r)
					.add(mid.multiply(two).subtract(one).multiply(mid))
					.compareTo(t) <= 0){
				low = mid;
			}else{
				high = mid;
			}
		}
		
		return low.toString();
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner in = new Scanner(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
		in.nextLine(); //no need to store number of test cases
		int tCase = 1;
		BigIntegerStringConverter cv = new BigIntegerStringConverter();
		while(in.hasNext()){			
			String[] rt = in.nextLine().split(" ");
			writer.println("Case #"+tCase+": "+solve(cv.fromString(rt[0]), cv.fromString(rt[1])));
			tCase++;
		}
		in.close();
		writer.close();
	}

}
