import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class CJ2010QualifB {
	
	public static void solve(String[] toReverse){
		for(int i = toReverse.length-1; i > 0; i--){
			System.out.print(toReverse[i] + " ");
		}
		System.out.println(toReverse[0]);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("in.txt"));
		in.nextLine(); //no need to store number of test cases
		int tCase = 1;
		while(in.hasNext()){
			System.out.print("Case #"+tCase+": ");
			solve(in.nextLine().split(" "));
			tCase++;
		}
		in.close();
	}

}
