import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

import javafx.util.converter.BigIntegerStringConverter;


public class CJ20081AA {
	public static String solve(BigInteger[] v1, BigInteger[] v2){
		int n = v1.length;
		Arrays.sort(v1);
		Arrays.sort(v2);
		BigInteger min = BigInteger.ZERO;
		for(int i = 0; i < n; i++){
			min = min.add(v1[i].multiply(v2[n-1-i]));
		}
		return min.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner in = new Scanner(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
		in.nextLine(); //no need to store number of test cases
		int tCase = 1;
		BigIntegerStringConverter cv = new BigIntegerStringConverter();
		while(in.hasNext()){
			int n = Integer.parseInt(in.nextLine());
			BigInteger[] v1 = new BigInteger[n];
			BigInteger[] v2 = new BigInteger[n];
			
			String[] v1str = in.nextLine().split(" ");
			String[] v2str = in.nextLine().split(" ");
			for(int i = 0; i < n; i++){
				v1[i] = cv.fromString(v1str[i]);
				v2[i] = cv.fromString(v2str[i]);
			}
			writer.println("Case #"+tCase+": "+solve(v1, v2));
			tCase++;
		}
		in.close();
		writer.close();
	}

}
