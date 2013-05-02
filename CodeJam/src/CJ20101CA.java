import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class CJ20101CA {
	public static String solve(int[] As, int[] Bs){
		int N = As.length;
		int intersections = 0;
		for(int i = 0; i < N-1; i++){
			int left = As[i], right = Bs[i];
			
			for(int j = i+1; j < N; j++){
				if(As[j] > left && Bs[j] < right ||
						As[j] < left && Bs[j] > right){
					intersections++;
				}
			}
		}
		return String.valueOf(intersections);
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner in = new Scanner(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
		in.nextLine(); //no need to store number of test cases
		int tCase = 1;
		while(in.hasNext()){
			int N = Integer.parseInt(in.nextLine());
			
			int[] As = new int[N];
			int[] Bs = new int[N];
			for(int i = 0; i < N; i++){
				String[] t = in.nextLine().split(" ");
				As[i] = Integer.parseInt(t[0]);
				Bs[i] = Integer.parseInt(t[1]);
			}
			writer.println("Case #"+tCase+": "+solve(As, Bs));
			tCase++;
		}
		in.close();
		writer.close();
	}

}
