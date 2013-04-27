import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class CJ2010QualifA {
	public static void solve(int credit, int[] prices){
		for(int i = 0; i < prices.length - 1; i++){
			int pi = prices[i];
			if(pi >= credit) continue;
			int needed = credit - pi;
			for(int j = i+1; j < prices.length; j++){
				if(prices[j] == needed){
					System.out.println((i+1) + " "+(j+1));
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("in.txt"));
		in.nextLine(); //no need to store number of test cases
		int tCase = 1;
		while(in.hasNext()){
			int credit = Integer.parseInt(in.nextLine());
			in.nextLine(); //skip item number
			String[] p = in.nextLine().split(" ");
			int[] prices = new int[p.length];
			for(int i = 0; i < prices.length; i++){
				prices[i] = Integer.parseInt(p[i]);
			}
			
			System.out.print("Case #"+tCase+": ");
			solve(credit, prices);
			tCase++;
		}
		in.close();
	}

}
